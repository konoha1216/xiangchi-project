package com.xiangchi.xiangchiproject.costDetail.po;

import com.xiangchi.xiangchiproject.costDetail.dto.CostDetailDto;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailCreateParam;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailUpdateParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.math.BigDecimal;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CostDetailPo {

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
    
    private Integer isDeleted;

    public static CostDetailPo convertFromCreateParam(CostDetailCreateParam createParam) {
        if (null == createParam) {
            return null;
        }
        return CostDetailPo.builder()
                .type(createParam.getType())
                .otherType(Optional.ofNullable(createParam.getOtherType()).orElse(0))
                .cost(createParam.getCost())
                .projectOrderId(createParam.getProjectOrderId())
                .comment(Optional.ofNullable(createParam.getComment()).orElse(Strings.EMPTY))
                .build();
    }

    public static CostDetailPo convertFromUpdateParam(CostDetailUpdateParam updateParam) {
        if (null == updateParam) {
            return null;
        }
        return CostDetailPo.builder()
                .id(updateParam.getId())
                .type(updateParam.getType())
                .otherType(Optional.ofNullable(updateParam.getOtherType()).orElse(0))
                .cost(updateParam.getCost())
                .projectOrderId(updateParam.getProjectOrderId())
                .comment(Optional.ofNullable(updateParam.getComment()).orElse(Strings.EMPTY))
                .build();
    }

    public static CostDetailDto convertToDto(CostDetailPo po) {
        if (null == po) {
            return null;
        }
        return CostDetailDto.builder()
                .id(po.getId())
                .type(po.getType())
                .otherType(po.getOtherType())
                .cost(po.getCost())
                .projectOrderId(po.getProjectOrderId())
                .comment(po.getComment())
                .build();
    }
}
