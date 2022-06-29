package com.xiangchi.xiangchiproject.projectSource.service;

import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourceCreateParam;
import com.xiangchi.xiangchiproject.utils.ResultInfo;

public interface ProjectSourceService {

    ResultInfo<Long> create(ProjectSourceCreateParam param);
}
