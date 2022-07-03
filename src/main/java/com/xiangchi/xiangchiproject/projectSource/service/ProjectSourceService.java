package com.xiangchi.xiangchiproject.projectSource.service;

import com.xiangchi.xiangchiproject.projectSource.model.dto.ProjectSourceDetailDto;
import com.xiangchi.xiangchiproject.projectSource.model.dto.ProjectSourcePageDto;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourceCreateParam;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourcePageParam;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourceUpdateParam;
import com.xiangchi.xiangchiproject.utils.ResultInfo;

import java.util.Set;

public interface ProjectSourceService {

    ResultInfo<Long> create(ProjectSourceCreateParam param);

    ResultInfo<Long> update(ProjectSourceUpdateParam param);
    
    ResultInfo delete(Set<Long> ids);

    ResultInfo<ProjectSourceDetailDto> detail(Long id);

    ResultInfo<ProjectSourcePageDto> page(ProjectSourcePageParam param);
}
