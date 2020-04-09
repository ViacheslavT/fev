package com.feg.lab.csv.rest.exceptions;

import com.feg.lab.csv.rest.model.dto.base.ErrorCode;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
public class ClientNotSupportedException extends BaseClientException {

    private static ErrorCode errorCode = ErrorCode.NOT_FOUND;

    public ClientNotSupportedException(String message) {
        super(errorCode, message);
    }
}
