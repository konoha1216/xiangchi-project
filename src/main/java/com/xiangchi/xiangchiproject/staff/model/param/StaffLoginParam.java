package com.xiangchi.xiangchiproject.staff.model.param;

import com.xiangchi.xiangchiproject.utils.ResultInfo;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
@Builder
public class StaffLoginParam {

    private String code;

    private String password;

    public ResultInfo<String> check() {
        if (!StringUtils.hasLength(this.code) || !StringUtils.hasLength(this.password)) {
            return ResultInfo.error("登录时用户编号和密码不能缺少");
        }
        return ResultInfo.success();
    }
}
