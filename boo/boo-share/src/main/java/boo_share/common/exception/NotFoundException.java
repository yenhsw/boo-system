package boo_share.common.exception;

import boo_share.common.response.ApiResponseCode;

public class NotFoundException extends BusinessException {

    public NotFoundException() {
        super(ApiResponseCode.NOT_FOUND);
    }

}
