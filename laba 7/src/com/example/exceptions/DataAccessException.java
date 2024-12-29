package com.example.exceptions;

public class DataAccessException extends Exception {
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(String message) {
        super(message);
    }
}