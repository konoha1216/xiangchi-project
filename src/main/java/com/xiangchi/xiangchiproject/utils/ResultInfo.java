package com.xiangchi.xiangchiproject.utils;

import lombok.Data;

@Data
public class ResultInfo<T> {

    private boolean isRight;

    private String message;

    private T data;

    public ResultInfo(boolean isRight, String message, T data) {
        this.isRight = isRight;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultInfo<T> success(T data) {return new ResultInfo<>(true, "success", data);}

    public static <T> ResultInfo<T> success() {return new ResultInfo<>(true, "success", null);}

    public static <T> ResultInfo<T> error(String message) {return new ResultInfo<>(false, message, null);}

    public static <T> ResultInfo<T> error(String message, T data) {return new ResultInfo<>(false, message, data);}
}
