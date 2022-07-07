package com.xiangchi.xiangchiproject.restreamDetail.param;

import com.xiangchi.xiangchiproject.utils.ResultInfo;
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
public class RestreamDetailCreateParam {
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

    public ResultInfo<String> check() {
        if (null == qty) {
            return ResultInfo.error("回款金额不能为空");
        }
        if (null == date) {
            return ResultInfo.error("回款时间不能为空");
        }
        if (projectOrderId == null) {
            return ResultInfo.error("项目单id不能为空");
        }
        return ResultInfo.success();
    }
}
