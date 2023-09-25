package com.winsen.demo.exception;

import org.apache.ibatis.javassist.NotFoundException;

public class InvalidProductException extends NotFoundException {

    public InvalidProductException(String msg) {
        super(msg);
    }
}
