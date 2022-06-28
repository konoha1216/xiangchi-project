package com.xiangchi.xiangchiproject.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiRestResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException: ", e);
        return handleBindingResult(e.getBindingResult());
    }

    private ApiRestResponse handleBindingResult(BindingResult result) {
        //把异常处理为对外暴露的提示
        List<String> list = new ArrayList<>();
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError objectError : allErrors) {
                String message = objectError.getDefaultMessage();
                list.add(message);
            }
        }
        if (list.size() == 0) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数错误");
        }
        return ApiRestResponse
                .error(ResponseCodeEnum.BAD_REQUEST, list.toString());
    }
}
