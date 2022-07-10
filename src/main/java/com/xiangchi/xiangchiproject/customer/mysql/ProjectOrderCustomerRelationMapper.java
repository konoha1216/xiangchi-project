package com.xiangchi.xiangchiproject.customer.mysql;

import com.xiangchi.xiangchiproject.customer.param.ProjectOrderCustomerRelationListParam;
import com.xiangchi.xiangchiproject.customer.po.ProjectOrderCustomerRelationPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface ProjectOrderCustomerRelationMapper {

    void insertAll(@Param("pos") Set<ProjectOrderCustomerRelationPo> poList);

    void deleteAll(@Param("ids") Set<Long> ids);

    List<ProjectOrderCustomerRelationPo> list(@Param("param")ProjectOrderCustomerRelationListParam param);

}
