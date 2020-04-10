package com.feg.lab.csv.rest.model.dto.base;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
public enum  ErrorCode {

    /** Validation error. Any errors during validation of request. */
    VALIDATION(0, "Validation error.", 400),
    /** General error during data processing from legacy APB services. */
    INTERNAL_ERROR(2, "Unexpected behaviour. An internal error with data processing.", 500),
    MISSING_PARAMETER(4, "Missing servlet parameter.", 400),
    FORBIDDEN_OPERATION_ERROR(6, "Forbidden operation.", 403),
    EXTERNAL_SERVER_TIME_OUT_ERROR(7, "External server timeout.", 504),
    NOT_FOUND(9, "The resource not found or not supported", 404);

    /** The integer representation of mapped error. */
    private int errorCode;
    /** The long description of the error happened. */
    private String message;
    /** The integer representation of HTTP status code */
    private int httpStatus;

    ErrorCode(final int errorCode, final String message, final int httpStatus) {
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public static int getStatusByErrorCode(final int errorCode) {
        int result = 500;
        for (ErrorCode code : ErrorCode.values()) {
            if (code.getErrorCode() == errorCode) {
                result = code.getHttpStatus();
                break;
            }
        }
        return result;
    }
}
