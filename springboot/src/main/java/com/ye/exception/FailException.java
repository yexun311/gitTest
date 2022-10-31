package com.ye.exception;

/**
 * 自定义失败异常
 */
public class FailException extends RuntimeException {

    public FailException() {
        super();
    }

    public FailException(String message) {
        super(message);
    }

    public FailException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailException(Throwable cause) {
        super(cause);
    }

    protected FailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
