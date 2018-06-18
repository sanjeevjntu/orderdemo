package com.example.sanjeev.orderdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Locale;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleValidationException(MethodArgumentNotValidException exception) {
        LOGGER.error(exception.getMessage(), exception);

        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                exception.getBindingResult().getFieldErrors()
        );
    }

    @ExceptionHandler(value = {BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleValidationException(BindException exception) {
        LOGGER.error(exception.getMessage(), exception);

        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                exception.getBindingResult().getFieldErrors()
        );
    }

    private ErrorResponse buildErrorResponse(HttpStatus status, List<FieldError> errors) {
        ErrorResponse instance = ErrorResponse
                .createInstance()
                .setStatus(status.value())
                .setTimestamp(System.currentTimeMillis());

        errors.forEach((FieldError error) -> {
            instance.addMessage(messageSource.getMessage(
                    error.getDefaultMessage(),
                    null,
                    Locale.getDefault()
            ));
        });

        return instance;
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class, IllegalArgumentException.class, MissingServletRequestParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleException(Exception exception) {
        LOGGER.error(exception.getMessage(), exception);

        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                exception
        );
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ErrorResponse handleGenericException(Exception exception) {
        LOGGER.error(exception.getMessage(), exception);

        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception
        );
    }

    private ErrorResponse buildErrorResponse(HttpStatus status, Exception exception) {
        return ErrorResponse
                .createInstance()
                .setStatus(status.value())
                .addMessage(exception.getMessage())
                .setTimestamp(System.currentTimeMillis());
    }
}

