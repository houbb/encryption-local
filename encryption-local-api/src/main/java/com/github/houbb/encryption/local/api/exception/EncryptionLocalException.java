package com.github.houbb.encryption.local.api.exception;

/**
 * 加密机 异常
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class EncryptionLocalException extends RuntimeException {

    public EncryptionLocalException() {
    }

    public EncryptionLocalException(String message) {
        super(message);
    }

    public EncryptionLocalException(String message, Throwable cause) {
        super(message, cause);
    }

    public EncryptionLocalException(Throwable cause) {
        super(cause);
    }

    public EncryptionLocalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
