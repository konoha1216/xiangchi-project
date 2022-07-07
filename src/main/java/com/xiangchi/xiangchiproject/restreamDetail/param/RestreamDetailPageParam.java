package com.xiangchi.xiangchiproject.restreamDetail.param;

import com.xiangchi.xiangchiproject.common.model.PageParam;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestreamDetailPageParam {
    /**
     * 关联的项目单id
     */
    private Long projectOrderId;
    /**
     * 根据什么排序 1金额2时间
     */
    private Integer orderBy;
    /**
     * 0升序1降序
     */
    private Integer orderByOrder;

    private PageParam pageParam;

    public ResultInfo<String> check() {
        if (orderBy != null && orderByOrder == null) {
            return ResultInfo.error("指定排序项时必须指定排序规则");
        }
        return ResultInfo.success();
    }
}
