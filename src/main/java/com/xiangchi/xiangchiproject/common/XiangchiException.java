package com.xiangchi.xiangchiproject.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class XiangchiException extends RuntimeException{

    private ResponseCodeEnum responseCodeEnum;

    public XiangchiException(ResponseCodeEnum error, String errormessage) {
        super(errormessage);
        this.setResponseCodeEnum(error);
    }

    public XiangchiException(String errorMessage) {
        super(errorMessage);
        this.setResponseCodeEnum(ResponseCodeEnum.INTERNAL_SERVER_ERROR);
    }

    public XiangchiException(String errorMessage, Exception e) {
        super(errorMessage, e);
        this.setResponseCodeEnum(ResponseCodeEnum.INTERNAL_SERVER_ERROR);
    }
}
