package com.xiangchi.xiangchiproject.projectSource.repository.mysql;

import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourcePageParam;
import com.xiangchi.xiangchiproject.projectSource.model.po.ProjectSourcePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface ProjectSourceMapper {

    void insert(@Param("po") ProjectSourcePo po);

    void update(@Param("po") ProjectSourcePo po);

    void delete(Set<Long> ids);

    ProjectSourcePo queryOne(@Param("id") Long id);

    List<ProjectSourcePo> pageByParam(@Param("param") ProjectSourcePageParam param);

    int countByParam(@Param("param") ProjectSourcePageParam param);
}
