package com.xiangchi.xiangchiproject.costDetail.param;

import com.xiangchi.xiangchiproject.utils.ResultInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CostDetailCreateParam {
    /**
     * 费用类型：0客户 1其他
     */
    private Integer type;
    /**
     * 其他费用明细类型：0服务 1专家 2礼品 3其他
     */
    private Integer otherType;
    /**
     * 金额
     */
    private BigDecimal cost;
    /**
     * 项目单id
     */
    private Long projectOrderId;
    /**
     * 备注
     */
    private String comment;

    public ResultInfo<String> check() {
        if (null == type) {
            return ResultInfo.error("费用类型不能为空");
        }
        if (type == 1 && otherType == null) {
            return ResultInfo.error("费用类型为其他时明细类型不能为空");
        }
        if (cost == null) {
            return ResultInfo.error("金额不能为空");
        }
        if (projectOrderId == null) {
            return ResultInfo.error("项目单id不能为空");
        }
        return ResultInfo.success();
    }
}
