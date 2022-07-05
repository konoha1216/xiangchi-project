package com.xiangchi.xiangchiproject.costDetail.mysql;

import com.xiangchi.xiangchiproject.costDetail.param.CostDetailPageParam;
import com.xiangchi.xiangchiproject.costDetail.po.CostDetailPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface CostDetailMapper {

    void insert(@Param("po") CostDetailPo po);

    void update(@Param("po") CostDetailPo po);

    void delete(Set<Long> ids);

    List<CostDetailPo> pageByParam(@Param("param") CostDetailPageParam param);

    Integer countByParam(@Param("param") CostDetailPageParam param);
}
