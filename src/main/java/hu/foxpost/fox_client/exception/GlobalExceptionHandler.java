package hu.foxpost.fox_client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({FoxClientException.class})
    public ResponseEntity<Object> handleFoxClientException(Exception ex, WebRequest request) {
        FoxClientException parcelHandlerException = (FoxClientException) ex;
        ApiError apiError = parcelHandlerException.getApiError();

        if (apiError != null) {
            return new ResponseEntity<>(apiError, null, apiError.getStatus());
        }

        return new ResponseEntity<>("An unknown error occurred while communicating with the external service.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
