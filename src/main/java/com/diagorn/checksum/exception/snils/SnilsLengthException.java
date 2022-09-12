package com.diagorn.checksum.exception.snils;

/**
 * Exception to be thrown when snils has more or less characters than needed
 *
 * @author Diagorn
 */
public class SnilsLengthException extends SnilsException {
    public SnilsLengthException(String message) {
        super(message);
    }
}
