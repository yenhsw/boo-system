package boo_blog_service.common.exception;

import boo_share.common.exception.BusinessException;
import boo_share.common.response.ApiResponse;
import boo_share.common.response.ApiResponseCode;
import boo_share.common.response.ApiResponseUtil;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Hidden
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

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse<Void>> handleAccessDenied(
            AccessDeniedException ex
    ) {
        return ResponseEntity
                .status(ApiResponseCode.FORBIDDEN.code())
                .body(ApiResponseUtil.error(ApiResponseCode.FORBIDDEN));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception ex) {
        return ResponseEntity
                .status(ApiResponseCode.INTERNAL_ERROR.code())
                .body(ApiResponseUtil.error(ApiResponseCode.INTERNAL_ERROR));
    }
}
