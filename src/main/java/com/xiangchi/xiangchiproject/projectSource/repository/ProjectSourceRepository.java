package com.xiangchi.xiangchiproject.projectSource.repository;

import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourcePageParam;
import com.xiangchi.xiangchiproject.projectSource.model.po.ProjectSourcePo;

import java.util.List;
import java.util.Set;

public interface ProjectSourceRepository {

    Long insert(ProjectSourcePo po);

    Long update(ProjectSourcePo po);

    void delete(Set<Long> ids);

    ProjectSourcePo queryOne(Long id);

    List<ProjectSourcePo> pageList(ProjectSourcePageParam param);

    Integer count(ProjectSourcePageParam param);
}
