package com.zhentao.cors.example.exception;

public class EmployeeExistsException extends RuntimeException {
    private static final long serialVersionUID = -3593454220087466701L;

    public EmployeeExistsException() {
        super();
    }

    public EmployeeExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeExistsException(String message) {
        super(message);
    }

    public EmployeeExistsException(Throwable cause) {
        super(cause);
    }
}
