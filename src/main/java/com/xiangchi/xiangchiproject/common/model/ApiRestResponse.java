package com.xiangchi.xiangchiproject.common.model;

import lombok.Data;

@Data
public class ApiRestResponse<T> {

    private Integer code;

    private String message;

    private T data;

    private static final int SUCCESS_CODE = 200;

    private static final String SUCCESS_MESSAGE = "success";

    public ApiRestResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiRestResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiRestResponse(){
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static <T> ApiRestResponse<T> success() {
        return new ApiRestResponse<>();
    }

    public static <T> ApiRestResponse<T> success(T result) {
        ApiRestResponse<T> response = new ApiRestResponse<>();
        response.setData(result);
        return response;
    }

    public static ApiRestResponse error(ResponseCodeEnum responseCodeEnum, String message) {
        return new ApiRestResponse<>(responseCodeEnum.getCode(), message);
    }

    public static ApiRestResponse error(ResponseCodeEnum responseCodeEnum) {
        return new ApiRestResponse<>(responseCodeEnum.getCode(), responseCodeEnum.getMessage());
    }
}
