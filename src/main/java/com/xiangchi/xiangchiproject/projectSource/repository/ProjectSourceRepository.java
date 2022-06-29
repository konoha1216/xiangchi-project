package com.xiangchi.xiangchiproject.projectSource.repository;

import com.xiangchi.xiangchiproject.projectSource.model.po.ProjectSourcePo;
import com.xiangchi.xiangchiproject.utils.ResultInfo;

public interface ProjectSourceRepository {

    ResultInfo<Long> insert(ProjectSourcePo po);
}
