package com.xiangchi.xiangchiproject.costDetail.param;

import com.xiangchi.xiangchiproject.utils.ResultInfo;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CostDetailUpdateParam extends CostDetailCreateParam{

    private Long id;

    public ResultInfo<String> check() {
        if (id == null) {
            return ResultInfo.error("id不能为空");
        }
        return super.check();
    }
}
