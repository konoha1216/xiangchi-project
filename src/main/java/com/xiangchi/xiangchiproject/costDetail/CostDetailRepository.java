package com.xiangchi.xiangchiproject.costDetail;

import com.xiangchi.xiangchiproject.costDetail.param.CostDetailPageParam;
import com.xiangchi.xiangchiproject.costDetail.po.CostDetailPo;

import java.util.List;
import java.util.Set;

public interface CostDetailRepository {

    Long insertOne(CostDetailPo po);

    Long updateOne(CostDetailPo po);

    void deleteOne(Set<Long> ids);

    List<CostDetailPo> page(CostDetailPageParam param);

    Integer count(CostDetailPageParam param);
}
