package com.blogApi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestControllerAdvice
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String description;

    @Override
    public String toString() {
        return "ErrorDetails [timestamp=" + timestamp + ", message=" + message + ", details=" + description + "]";
    }
}
