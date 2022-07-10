package com.xiangchi.xiangchiproject.contact.param;

import com.xiangchi.xiangchiproject.utils.ResultInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactCreateParam {

    private String name;

    private String code;

    private String phone;

    private String email;

    private Long customerId;

    private String comment;

    public ResultInfo<String> check() {
        if (!StringUtils.hasLength(name)) {
            return ResultInfo.error("客户名称不能为空");
        }
        if (!StringUtils.hasLength(code)) {
            return ResultInfo.error("客户编号不能为空");
        }
        if (null == customerId) {
            return ResultInfo.error("所属客户不能为空");
        }
        return ResultInfo.success();
    }
}
