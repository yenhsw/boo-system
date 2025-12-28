package boo_core.common.exception;

import boo_share.common.exception.BusinessException;
import boo_share.common.response.ApiResponse;
import boo_share.common.response.ApiResponseCode;
import boo_share.common.response.ApiResponseUtil;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessException(
            BusinessException ex
    ) {
        ApiResponseCode code = ex.getResponseCode();

        return ResponseEntity
                .status(code.code())
                .body(ApiResponseUtil.error(code));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception ex) {

        return ResponseEntity
                .status(ApiResponseCode.INTERNAL_ERROR.code())
                .body(ApiResponseUtil.error(ApiResponseCode.INTERNAL_ERROR));
    }
}
