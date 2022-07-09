package com.xiangchi.xiangchiproject.customer.param;

import com.xiangchi.xiangchiproject.utils.ResultInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreateParam {

    private String name;

    private String code;

    private String comment;

    public ResultInfo<String> check() {
        if (null == name) {
            return ResultInfo.error("客户名称不能为空");
        }
        if (null == code) {
            return ResultInfo.error("客户编号不能为空");
        }
        return ResultInfo.success();
    }
}
