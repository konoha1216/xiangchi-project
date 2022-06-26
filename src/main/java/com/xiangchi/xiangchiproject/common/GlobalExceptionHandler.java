package com.xiangchi.xiangchiproject.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiRestResponse handleException(Exception e) {
        log.error("default error: ", e);
        return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, "系统出小差了...");
    }

    @ExceptionHandler(XiangchiException.class)
    @ResponseBody
    public ApiRestResponse handleException(XiangchiException e) {
        log.error("xiangchi error: ", e);
        return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
