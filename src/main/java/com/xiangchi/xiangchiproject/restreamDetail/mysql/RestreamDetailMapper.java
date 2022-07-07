package com.xiangchi.xiangchiproject.restreamDetail.mysql;

import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailPageParam;
import com.xiangchi.xiangchiproject.restreamDetail.po.RestreamDetailPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface RestreamDetailMapper {

    void insert(@Param("po") RestreamDetailPo po);

    void update(@Param("po") RestreamDetailPo po);

    void delete(Set<Long> ids);

    List<RestreamDetailPo> pageByParam(@Param("param") RestreamDetailPageParam param);

    Integer countByParam(@Param("param") RestreamDetailPageParam param);
}
