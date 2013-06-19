package com.zhentao.cors.example.exception;

public class IdNotMatchException extends RuntimeException {
    private static final long serialVersionUID = -6876680943656291728L;

    public IdNotMatchException() {
        super();
    }

    public IdNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdNotMatchException(String message) {
        super(message);
    }

    public IdNotMatchException(Throwable cause) {
        super(cause);
    }
}
