package com.xiangchi.xiangchiproject.restreamDetail;

import com.xiangchi.xiangchiproject.restreamDetail.dto.RestreamDetailPageDto;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailCreateParam;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailPageParam;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailUpdateParam;
import com.xiangchi.xiangchiproject.utils.ResultInfo;

public interface RestreamDetailService {

    ResultInfo<Long> createOne(RestreamDetailCreateParam param);

    ResultInfo<Long> updateOne(RestreamDetailUpdateParam param);

    ResultInfo deleteOne(Long id);

    ResultInfo<RestreamDetailPageDto> page(RestreamDetailPageParam param);
}
