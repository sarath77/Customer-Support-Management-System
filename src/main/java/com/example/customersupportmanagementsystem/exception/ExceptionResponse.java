package com.example.customersupportmanagementsystem.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {

    private String errorCode;
    private String errorMessage;
    private String requestedURI;
}
