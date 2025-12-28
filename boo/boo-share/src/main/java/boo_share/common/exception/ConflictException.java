package boo_share.common.exception;

import boo_share.common.response.ApiResponseCode;

public class ConflictException extends BusinessException{

    public ConflictException() {
        super(ApiResponseCode.CONFLICT);
    }
}
