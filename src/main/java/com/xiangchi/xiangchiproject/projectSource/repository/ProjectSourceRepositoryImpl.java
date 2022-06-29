package com.xiangchi.xiangchiproject.projectSource.repository;

import com.xiangchi.xiangchiproject.projectSource.model.po.ProjectSourcePo;
import com.xiangchi.xiangchiproject.projectSource.repository.mysql.ProjectSourceMapper;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ProjectSourceRepositoryImpl implements ProjectSourceRepository{

    @Resource
    private ProjectSourceMapper projectSourceMapper;

    @Override
    public ResultInfo<Long> insert(ProjectSourcePo po) {
        projectSourceMapper.insert(po);
        return ResultInfo.success(po.getId());
    }
}
