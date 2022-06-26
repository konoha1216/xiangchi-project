package com.xiangchi.xiangchiproject.staff.model.param;

import com.xiangchi.xiangchiproject.utils.ResultInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StaffUpdateParam {

    private Long id;

    private String name;

    private String code;

    private String phone;

    private String email;

    private String comment;

    public ResultInfo<String> check() {
        if (null == this.id) {
            return ResultInfo.error("更新用户时必须指定用户id");
        }
        return ResultInfo.success();
    }
}
