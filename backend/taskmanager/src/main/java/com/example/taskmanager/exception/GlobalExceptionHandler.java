package com.example.taskmanager.exception;

import com.example.taskmanager.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class )
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleValidationException(MethodArgumentNotValidException ex){
//        return ex.getMessage();

            return new ErrorResponse(
                    400,
                    ex.getMessage()
            );

    }
}
