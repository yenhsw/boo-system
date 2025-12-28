package boo_share.common.response;

public class ApiResponseUtil {

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .code(ApiResponseCode.SUCCESS.code())
                .message(ApiResponseCode.SUCCESS.message())
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> created(T data) {
        return ApiResponse.<T>builder()
                .code(ApiResponseCode.CREATED.code())
                .message(ApiResponseCode.CREATED.message())
                .data(data)
                .build();
    }

    public static ApiResponse<Void> noContent() {
        return ApiResponse.<Void>builder()
                .code(ApiResponseCode.NO_CONTENT.code())
                .message(ApiResponseCode.NO_CONTENT.message())
                .build();
    }

    public static ApiResponse<Void> error(ApiResponseCode code) {
        return ApiResponse.<Void>builder()
                .code(code.code())
                .message(code.message())
                .build();
    }
}
