package com.xiangchi.xiangchiproject.costDetail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CostDetailDto {
    /**
     * 主键id
     */
    private Long id;
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
}
