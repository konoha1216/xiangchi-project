package com.xiangchi.xiangchiproject.restreamDetail.po;

import com.xiangchi.xiangchiproject.restreamDetail.dto.RestreamDetailDto;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailCreateParam;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailUpdateParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestreamDetailPo {
    
    private Long id;
    /**
     * 回款金额
     */
    private BigDecimal qty;
    /**
     * 回款时间
     */
    private LocalDateTime date;
    /**
     * 项目单id
     */
    private Long projectOrderId;
    /**
     * 备注
     */
    private String comment;

    private Integer isDeleted;

    public static RestreamDetailPo convertFromCreateParam(RestreamDetailCreateParam createParam) {
        if (null == createParam) {
            return null;
        }
        return RestreamDetailPo.builder()
                .qty(createParam.getQty())
                .date(createParam.getDate())
                .projectOrderId(createParam.getProjectOrderId())
                .comment(Optional.ofNullable(createParam.getComment()).orElse(Strings.EMPTY))
                .build();
    }

    public static RestreamDetailPo convertFromUpdateParam(RestreamDetailUpdateParam updateParam) {
        if (null == updateParam) {
            return null;
        }
        return RestreamDetailPo.builder()
                .id(updateParam.getId())
                .qty(updateParam.getQty())
                .date(updateParam.getDate())
                .projectOrderId(updateParam.getProjectOrderId())
                .comment(Optional.ofNullable(updateParam.getComment()).orElse(Strings.EMPTY))
                .build();
    }

    public static RestreamDetailDto convertToDto(RestreamDetailPo po) {
        if (null == po) {
            return null;
        }
        return RestreamDetailDto.builder()
                .id(po.getId())
                .qty(po.getQty())
                .date(po.getDate())
                .projectOrderId(po.getProjectOrderId())
                .comment(po.getComment())
                .build();
    }
}
