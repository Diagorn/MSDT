package com.diagorn.checksum.exception.snils;

/**
 * Exception to be thrown if the snils checksum is invalid
 *
 * @author Diagorn
 */
public class SnilsChecksumException extends SnilsException {
    public SnilsChecksumException(String message) {
        super(message);
    }
}
