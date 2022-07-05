package com.xiangchi.xiangchiproject.costDetail;

import com.xiangchi.xiangchiproject.costDetail.dto.CostDetailPageDto;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailCreateParam;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailPageParam;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailUpdateParam;
import com.xiangchi.xiangchiproject.utils.ResultInfo;

public interface CostDetailService {

    ResultInfo<Long> createOne(CostDetailCreateParam param);

    ResultInfo<Long> updateOne(CostDetailUpdateParam param);

    ResultInfo deleteOne(Long id);

    ResultInfo<CostDetailPageDto> page(CostDetailPageParam param);
}
