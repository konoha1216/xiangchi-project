package com.xiangchi.xiangchiproject.restreamDetail.param;

import com.xiangchi.xiangchiproject.utils.ResultInfo;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RestreamDetailUpdateParam extends RestreamDetailCreateParam{

    private Long id;

    public ResultInfo<String> check() {
        if (id == null) {
            return ResultInfo.error("id不能为空");
        }
        return super.check();
    }
}
