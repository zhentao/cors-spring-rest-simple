package com.zhentao.cors.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee doesn't exist")
public class EmployeeNotExistsException extends RuntimeException{
    private static final long serialVersionUID = -840216217051508011L;
}
