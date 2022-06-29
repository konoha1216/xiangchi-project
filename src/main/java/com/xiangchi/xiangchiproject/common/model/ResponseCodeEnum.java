package com.xiangchi.xiangchiproject.common.model;

public enum ResponseCodeEnum {
    SUCCESS(200, "success"),

    BAD_REQUEST(400, "bad request"),

    NOT_LOGIN(401, "not login"),

    UNAUTHORIZED(402, "unauthorized"),

    FORBIDDEN(403, "forbidden"),

    NOT_FOUND(404, "not found"),

    INTERNAL_SERVER_ERROR(500, "internal server error");

    private Integer code;

    private String message;

    ResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
