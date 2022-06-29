package com.xiangchi.xiangchiproject.projectSource.repository.mysql;

import com.xiangchi.xiangchiproject.projectSource.model.po.ProjectSourcePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectSourceMapper {

    void insert(@Param("po") ProjectSourcePo po);
}
