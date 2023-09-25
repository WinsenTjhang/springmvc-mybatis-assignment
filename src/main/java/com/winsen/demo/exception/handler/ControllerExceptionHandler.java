package com.winsen.demo.exception.handler;

import com.winsen.demo.exception.*;
import com.winsen.demo.exception.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(FailedUpdatePaymentException.class)
    public ResponseEntity<ErrorMessage> handleFailedUpdatePayment(FailedUpdatePaymentException e) {
        ErrorMessage body = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                e.getMessage()
        );

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FailedUpdateQuantityException.class)
    public ResponseEntity<ErrorMessage> handleFailedUpdateQuantity(FailedUpdateQuantityException e) {
        ErrorMessage body = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                e.getMessage()
        );

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<ErrorMessage> handleInvalidProduct(InvalidProductException e) {
        ErrorMessage body = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                e.getMessage()
        );

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<ErrorMessage> handleInvalidUser(InvalidUserException e) {
        ErrorMessage body = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                e.getMessage()
        );

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidOrderRequestException.class)
    public ResponseEntity<ErrorMessage> handleInvalidOrderRequest(InvalidOrderRequestException e) {
        ErrorMessage body = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                e.getMessage()
        );

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


}
