package com.sapati.a_common.useCustom.exception;
import io.micronaut.serde.annotation.Serdeable;
@Serdeable
public class CustomException extends RuntimeException {
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
