package com.zhentao.cors.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Id Not Match")
public class IdNotMatchException extends RuntimeException {
    private static final long serialVersionUID = -6876680943656291728L;
}
