package com.diagorn.checksum.exception.snils;

/**
 * Exception of snils validation
 *
 * @author Diagorn
 */
public class SnilsException extends RuntimeException {
    public SnilsException() {
        super();
    }

    public SnilsException(String message) {
        super(message);
    }

    public SnilsException(String message, Throwable cause) {
        super(message, cause);
    }

    public SnilsException(Throwable cause) {
        super(cause);
    }

    protected SnilsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
