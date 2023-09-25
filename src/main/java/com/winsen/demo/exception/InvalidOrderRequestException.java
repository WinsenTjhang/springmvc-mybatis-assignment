package com.winsen.demo.exception;

public class InvalidOrderRequestException extends RuntimeException{
    public InvalidOrderRequestException(String message) {
        super(message);
    }
}
