package boo_share.common.exception;

import boo_share.common.response.ApiResponseCode;

public class ValidationException extends BusinessException {

    public ValidationException() {
        super(ApiResponseCode.VALIDATION_ERROR);
    }

}
