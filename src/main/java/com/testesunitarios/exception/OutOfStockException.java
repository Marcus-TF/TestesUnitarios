package com.testesunitarios.exception;

public class OutOfStockException extends AssertionError{

    public OutOfStockException(String message) {
        super(message);
    }
}
