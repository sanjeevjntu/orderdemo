package com.example.sanjeev.orderdemo;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

    private Integer statusCode;

    private List<String> messages;

    private Long timestamp;

    public static ErrorResponse createInstance() {
        return new ErrorResponse();
    }

    public ErrorResponse setStatus(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public ErrorResponse addMessage(String message) {
        if (this.messages == null) {
            this.messages = new ArrayList<>();
        }

        this.messages.add(message);

        return this;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public List<String> getMessages() {
        return messages;
    }

    public ErrorResponse setMessages(List<String> messages) {
        this.messages = messages;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public ErrorResponse setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}

