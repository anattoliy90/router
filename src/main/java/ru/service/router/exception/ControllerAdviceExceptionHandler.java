package ru.service.router.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ExceptionResponse handle(final ResourceNotFoundException exception) {
        return new ExceptionResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(InternalServerException.class)
    @ResponseBody
    public ExceptionResponse handle(final InternalServerException exception) {
        return new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseBody
    public ExceptionResponse handle(final ConflictException exception) {
        return new ExceptionResponse(HttpStatus.CONFLICT.value(), exception.getMessage());
    }
}
