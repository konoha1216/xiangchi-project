package com.xiangchi.xiangchiproject.restreamDetail;

import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailPageParam;
import com.xiangchi.xiangchiproject.restreamDetail.po.RestreamDetailPo;

import java.util.List;
import java.util.Set;

public interface RestreamDetailRepository {

    Long insertOne(RestreamDetailPo po);

    Long updateOne(RestreamDetailPo po);

    void deleteOne(Set<Long> ids);

    List<RestreamDetailPo> page(RestreamDetailPageParam param);

    Integer count(RestreamDetailPageParam param);
}
