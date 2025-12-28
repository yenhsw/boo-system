package boo_share.common.response;

public enum ApiResponseCode {

    // success
    SUCCESS(200, "MESSAGE.success"),
    CREATED(201, "MESSAGE.create_successfully"),
    UPDATED(202, "MESSAGE.update_successfully"),
    DELETED(203, "MESSAGE.delete_successfully"),
    NO_CONTENT(204, "MESSAGE.no_content"),

    // error
    BAD_REQUEST(400, "MESSAGE.bad_request"),
    VALIDATION_ERROR(422, "MESSAGE.validation_error"),
    UNAUTHORIZED(401, "MESSAGE.unauthorized"),
    FORBIDDEN(403, "MESSAGE.forbidden"),
    NOT_FOUND(404, "MESSAGE.not_found"),
    CONFLICT(409, "MESSAGE.conflict"),

    // server error
    INTERNAL_ERROR(500, "MESSAGE.internal_error"),
    SERVICE_UNAVAILABLE(503, "MESSAGE.service_unavailable");

    private final int code;
    private final String message;

    ApiResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() { return code; }
    public String message() { return message; }
}
