package com.feg.lab.csv.rest.exceptions;

import com.feg.lab.csv.rest.model.dto.base.ErrorCode;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
public class ClientInternalException extends BaseClientException {

    private static final ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;

    public ClientInternalException(final String message) {
        super(errorCode, message);
    }
}
