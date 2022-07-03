package com.xiangchi.xiangchiproject.projectSource.model.param;

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
public class ProjectSourceUpdateParam {

    private Long id;

    private String name;

    private String code;

    private String comment;

    public ResultInfo<String> check() {
        if (null == id) {
            return ResultInfo.error("id不能为空");
        }
        if (!StringUtils.hasLength(this.name) || !StringUtils.hasLength(this.code)) {
            return ResultInfo.error("来源名称和来源编号不能为空");
        }
        return ResultInfo.success();
    }
}
