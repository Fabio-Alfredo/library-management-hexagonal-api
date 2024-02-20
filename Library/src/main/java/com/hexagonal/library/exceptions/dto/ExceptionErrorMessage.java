package com.hexagonal.library.exceptions.dto;

public class ExceptionErrorMessage {
    private String error;

    public ExceptionErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
