package boo_share.common.exception;

import boo_share.common.response.ApiResponseCode;


public class BusinessException extends RuntimeException {

    private final ApiResponseCode responseCode;

    public BusinessException(ApiResponseCode responseCode) {
        super(responseCode.message());
        this.responseCode = responseCode;
    }

    public ApiResponseCode getResponseCode() {
        return responseCode;
    }
}
