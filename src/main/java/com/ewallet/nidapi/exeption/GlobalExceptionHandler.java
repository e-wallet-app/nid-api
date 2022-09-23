package com.ewallet.nidapi.exeption;

import com.ewallet.nidapi.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final String NOT_FOUND = "NO DATA FOUND";
    public static final String VALIDATION_ERROR = "VALIDATION ERROR";
    public static final String DUPLICATE_ENTRY = "DUPLICATE DATA FOUND";
    public static final String CONVERT_ERROR = "CANNOT CONVERT DATA";

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<?> handleNotFoundException(NotFoundException e) {
        ErrorResponse response = new ErrorResponse(NOT_FOUND, e.getMessage());
        this.printStackTrace(e);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateEntryException.class)
    protected ResponseEntity<?> handleDuplicateEntryException(NotFoundException e) {
        ErrorResponse response = new ErrorResponse(DUPLICATE_ENTRY, e.getMessage());
        this.printStackTrace(e);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConverterNotFoundException.class)
    protected ResponseEntity<?> handleDConverterNotFoundException(ConverterNotFoundException e) {
        ErrorResponse response = new ErrorResponse(CONVERT_ERROR, e.getMessage());
        this.printStackTrace(e);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        return getValidationErrorResponse(e, "Enter valid data in all required fields");
    }

    @ExceptionHandler(value = {BindException.class})
    protected ResponseEntity<Object> handleBindException(BindException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getValidationErrorResponse(e, "Request is not valid");
    }

    private ResponseEntity<Object> getValidationErrorResponse(BindException e, String message) {
        ErrorResponse response = new ErrorResponse(VALIDATION_ERROR, message);
        List<ItemValidationError> validationErrors = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach((v) -> validationErrors.add(new ItemValidationError(v.getObjectName(), v.getField(), v.getRejectedValue(), v.getDefaultMessage())));
        response.setErrorItems(validationErrors);
        this.printStackTrace(e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private void printStackTrace(Exception e) {
        StackTraceElement[] trace = e.getStackTrace();
        StringBuilder traceLines = new StringBuilder();
        traceLines.append("Caused By: ").append(e.fillInStackTrace()).append("\n");
        Arrays.stream(trace).filter(f -> f.getClassName().contains("com.ewallet")).forEach(f -> traceLines.append("\tat ").append(f).append("\n"));
        log.error(traceLines.toString());
    }
}
