package com.example.user_management.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@Data
public class UserException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
