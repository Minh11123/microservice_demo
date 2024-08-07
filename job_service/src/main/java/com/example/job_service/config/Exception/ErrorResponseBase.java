package com.example.job_service.config.Exception;

import org.springframework.http.HttpStatus;


public enum ErrorResponseBase {
    FILE_NOT_SUPPORT(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "error.file_not_support"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "error.item_not_found"),
    NOT_EXISTED(HttpStatus.NOT_FOUND, "Account ko tồn tại"),
    NOT_EXISTED_ACCOUNT(HttpStatus.NOT_FOUND, "Tài khoản không tồn tại"),
    LOGIN_FALSE(HttpStatus.FORBIDDEN, "Đăng nhập thất bại"),

    NOT_FOUND_COMPANY(HttpStatus.NOT_FOUND, "Company not found"),
    NOT_FOUND_CATEGORY(HttpStatus.NOT_FOUND, "Category not found"),

    IS_EXISTED(HttpStatus.INTERNAL_SERVER_ERROR, "Tài khoản này đã tồn tại"),
    NOT_EXISTED_DEPARTMENT(HttpStatus.INTERNAL_SERVER_ERROR, "Cong ty không tồn tại"),

    USER_NOT_EXISTED(HttpStatus.UNAUTHORIZED, "error.user_not_existed"),


    PASSWORD_INVALID(HttpStatus.INTERNAL_SERVER_ERROR, "error.password_invalid"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "error.Unauthorized"),
    DATA_ERROR(HttpStatus.FORBIDDEN, "error.data_error"),
    BAD_REQUEST(HttpStatus.FORBIDDEN,"error.bad_request"),
    INVALID_TIME(HttpStatus.INTERNAL_SERVER_ERROR,"error.invalid_time"),
    GROUP_CAN_NOT_UPDATE(HttpStatus.BAD_REQUEST, "error.not_update"),
    ROLE_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, "error.role_not_found"),
    ROLE_EXISTED(HttpStatus.INTERNAL_SERVER_ERROR, "error.role_existed"),
    ITEM_NOT_UPDATE(HttpStatus.INTERNAL_SERVER_ERROR, "error.item_not_update");
    public final HttpStatus status;
    public final String message;


    ErrorResponseBase(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
