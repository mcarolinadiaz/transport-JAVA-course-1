package com.solvd.transport;
/**
 * Custom exception class to represent invalid operation.
 */
public class InvalidOperationException extends Exception {
    public InvalidOperationException(String message) {
        super(message);
    }
}
