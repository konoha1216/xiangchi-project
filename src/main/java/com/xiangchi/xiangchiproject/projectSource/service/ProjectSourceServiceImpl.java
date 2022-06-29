package com.xiangchi.xiangchiproject.projectSource.service;

import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourceCreateParam;
import com.xiangchi.xiangchiproject.projectSource.model.po.ProjectSourcePo;
import com.xiangchi.xiangchiproject.projectSource.repository.ProjectSourceRepository;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProjectSourceServiceImpl implements ProjectSourceService{

    @Resource
    ProjectSourceRepository projectSourceRepository;

    @Override
    public ResultInfo<Long> create(ProjectSourceCreateParam param) {
        ProjectSourcePo projectSourcePo = ProjectSourcePo.convertFromCreateParam(param);
        return projectSourceRepository.insert(projectSourcePo);
    }
}
