package com.solvd.transport;
/**
 * Custom exception class to represent invalid kind of propulsion.
 */
public class InvalidPropulsion extends RuntimeException {
    public InvalidPropulsion(String message) {
        super(message);
    }
}
