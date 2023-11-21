package com.solvd.transport;
/**
 * Custom exception class to represent invalid value.
 */
public class InvalidValueException extends RuntimeException {
    public InvalidValueException(String message, Throwable error) {
        super(message, error);
    }
    public InvalidValueException(String message) {
        super(message);
    }

}
