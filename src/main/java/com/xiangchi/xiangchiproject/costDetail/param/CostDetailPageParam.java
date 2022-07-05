package com.xiangchi.xiangchiproject.costDetail.param;

import com.xiangchi.xiangchiproject.common.model.PageParam;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CostDetailPageParam {
    /**
     * 费用类型枚举
     */
    private List<Integer> typeList;
    /**
     * 其他费用明细类型枚举
     */
    private List<Integer> otherTypeList;
    /**
     * 关联的项目单名称模糊搜索
     */
    private String projectOrderNameLike;
    /**
     * 关联的项目单id
     */
    private Long projectOrderId;
    /**
     * 是否按照费用排序 0否1是
     */
    private Integer orderByCost;
    /**
     * 按照费用排序时是升序还是降序 0升1降
     */
    private Integer orderByCostOrder;

    private PageParam pageParam;

    public ResultInfo<String> check() {
        if (orderByCost != null && orderByCostOrder == null) {
            return ResultInfo.error("按照金额排序时必须指定排序规则");
        }
        return ResultInfo.success();
    }
}
