package com.hexagonal.library.exceptions.dto;

public class MessageAcceptedService {
    private String message;

    public MessageAcceptedService(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

