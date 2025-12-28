package boo_share.common.exception;

import boo_share.common.response.ApiResponseCode;

public class BadRequestException extends BusinessException{

    public BadRequestException() {
        super(ApiResponseCode.BAD_REQUEST);
    }

}
