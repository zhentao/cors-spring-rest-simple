package com.zhentao.cors.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Employee Exists")
public class EmployeeExistsException extends RuntimeException {
    private static final long serialVersionUID = -3593454220087466701L;
}
