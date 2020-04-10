package com.feg.lab.csv.rest.exceptions.handler;

import com.feg.lab.csv.rest.exceptions.BaseClientException;
import com.feg.lab.csv.rest.exceptions.ClientInternalException;
import com.feg.lab.csv.rest.exceptions.ClientNotSupportedException;
import com.feg.lab.csv.rest.model.dto.base.ErrorCode;
import com.feg.lab.csv.rest.model.dto.base.ErrorDetails;
import com.feg.lab.csv.rest.model.dto.base.ErrorRS;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 * Class {@link BaseExceptionHandler} is a child instance of {@link ResponseEntityExceptionHandler} which
 * provide functionality to handle any thrown exceptions from the application in Global"" scope.
 */
@ControllerAdvice
@RestController
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    public final ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                     final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        List<ErrorDetails> errors = new ArrayList<>();
        ErrorCode error = ErrorCode.VALIDATION;
        for (ObjectError bindingError: ex.getBindingResult().getAllErrors()) {
            ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), error.getErrorCode(), error.getMessage(), ((FieldError) bindingError).getField() + ". " + bindingError.getDefaultMessage());
            errors.add(errorDetails);
        }
        ErrorRS response = new ErrorRS();
        response.setErrors(errors);
        return new ResponseEntity<>(response, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(final BindException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        List<ErrorDetails> errors = new ArrayList<>();
        ErrorCode error = ErrorCode.VALIDATION;
        for (ObjectError bindingError: ex.getBindingResult().getAllErrors()) {
            ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), error.getErrorCode(), error.getMessage(), ((FieldError) bindingError).getField() + ". " + bindingError.getDefaultMessage());
            errors.add(errorDetails);
        }
        ErrorRS response = new ErrorRS();
        response.setErrors(errors);
        return new ResponseEntity<>(response, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(final MissingServletRequestParameterException ex, final HttpHeaders headers,
                                                                          final HttpStatus status, final WebRequest request) {
        List<ErrorDetails> errors = new ArrayList<>();
        ErrorCode error = ErrorCode.MISSING_PARAMETER;
        errors.add(new ErrorDetails(LocalDateTime.now(), error.getErrorCode(), error.getMessage() + " " + ex.getParameterName()
                , ex.getLocalizedMessage()));
        ErrorRS response = new ErrorRS();
        response.setErrors(errors);
        return new ResponseEntity<>(response, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        List<ErrorDetails> errors = new ArrayList<>();
        ErrorCode error = ErrorCode.VALIDATION;
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), error.getErrorCode(), error.getMessage(), ex.getLocalizedMessage());
        errors.add(errorDetails);
        ErrorRS response = new ErrorRS();
        response.setErrors(errors);
        return new ResponseEntity<>(response, headers, status);
    }

    @ExceptionHandler(ClientNotSupportedException.class)
    public final ResponseEntity<ErrorRS> handleClientNotSupportedException(final ClientNotSupportedException ex, final WebRequest request) {
        return prepareErrorResponse(ex);
    }

    @ExceptionHandler(ClientInternalException.class)
    public final ResponseEntity<ErrorRS> handleClientInternalException(final ClientInternalException ex, final WebRequest request) {
        return prepareErrorResponse(ex);
    }

    private ResponseEntity<ErrorRS> prepareErrorResponse(final BaseClientException ex) {
        List<ErrorDetails> errors = new ArrayList<>();
        ErrorCode error = ex.getErrorCode();
        errors.add(new ErrorDetails(LocalDateTime.now(), error.getErrorCode(), error.getMessage(), ex.getMessage()));
        ErrorRS response = new ErrorRS();
        response.setErrors(errors);
        return ResponseEntity.status(error.getHttpStatus()).body(response);
    }
}
