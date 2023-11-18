package com.solvd.transport;
// Custom exception class to represent negative values.
public class NegativeValueException extends RuntimeException {
    // Constructor with a message and a cause (error) for the exception.
    public NegativeValueException(String message, Throwable error) {
        super(message, error);
    }
    // Constructor with a message for the exception.
    public NegativeValueException(String message) {
        super(message);
    }
}
