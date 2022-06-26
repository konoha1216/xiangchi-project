package com.xiangchi.xiangchiproject.staff.model.param;

import com.xiangchi.xiangchiproject.utils.ResultInfo;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
@Builder
public class StaffRegistryParam {

    private String name;

    private String code;

    private String password;

    private String phone;

    private String email;

    private String comment;

    private Integer isAdmin;

    private Integer isVisit;

    public ResultInfo<String> check() {
        if (!StringUtils.hasLength(this.getName()) || !StringUtils.hasLength(this.getCode()) || !StringUtils.hasLength(this.getPassword())) {
            return ResultInfo.error("注册时用户姓名、编号、密码不能缺少");
        }
        if (this.getPassword().length() < 6) {
            return ResultInfo.error("密码长度不能小于6位");
        }
        return ResultInfo.success();
    }
}
