package hu.foxpost.fox_client.exception;

import com.fasterxml.jackson.databind.json.JsonMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * The aim of this class is to override the behavior of the default ErrorDecoder.
 *
 * The microservices (which called by FoxClientApplication) can return custom error messages in the form of an ApiError object.
 * When FoxClientApplication got response with status 4xx from a microservice: it tries to extract the ApiError object from the response body.
 * - If it succeeds: then the FoxClientApplication will use the same ApiError object in the response.
 * - If this fails: the process continues as normal, means the response will handle by the default ErrorDecoder.
 */
public class FeignClientErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Autowired
    JsonMapper jsonMapper;

    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus status = HttpStatus.valueOf(response.status());

        if (status.is4xxClientError()) {
            try {
                ApiError apiError = jsonMapper.readValue(response.body().asInputStream(), ApiError.class);
                return new FoxClientException(apiError.getError(), apiError);

            } catch (IOException ex) {
                return defaultErrorDecoder.decode(methodKey, response);
            }
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }

}
