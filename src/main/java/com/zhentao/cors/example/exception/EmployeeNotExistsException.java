package com.zhentao.cors.example.exception;


public class EmployeeNotExistsException extends RuntimeException{
    private static final long serialVersionUID = -840216217051508011L;

    public EmployeeNotExistsException() {
        super();
    }

    public EmployeeNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotExistsException(String message) {
        super(message);
    }

    public EmployeeNotExistsException(Throwable cause) {
        super(cause);
    }

}
