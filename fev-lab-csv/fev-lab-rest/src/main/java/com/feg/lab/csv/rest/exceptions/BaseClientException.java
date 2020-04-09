package com.feg.lab.csv.rest.exceptions;

import com.feg.lab.csv.rest.model.dto.base.ErrorCode;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
public class BaseClientException extends RuntimeException {

    private ErrorCode errorCode;

    public BaseClientException(final ErrorCode errorCode, final String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
