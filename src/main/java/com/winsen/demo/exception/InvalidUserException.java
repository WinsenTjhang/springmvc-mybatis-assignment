package com.winsen.demo.exception;

import org.apache.ibatis.javassist.NotFoundException;

public class InvalidUserException extends NotFoundException {

    public InvalidUserException(String msg) {
        super(msg);
    }
}
