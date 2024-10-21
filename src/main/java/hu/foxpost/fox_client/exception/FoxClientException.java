package hu.foxpost.fox_client.exception;

import lombok.Getter;

@Getter
public class FoxClientException extends RuntimeException {

    private final ApiError apiError;

    public FoxClientException(String message, ApiError apiError) {
        super(message);
        this.apiError = apiError;
    }

}
