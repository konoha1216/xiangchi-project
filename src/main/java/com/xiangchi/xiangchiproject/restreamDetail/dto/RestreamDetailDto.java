package com.xiangchi.xiangchiproject.restreamDetail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestreamDetailDto {
    /**
     * 主键id
     */
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
}
