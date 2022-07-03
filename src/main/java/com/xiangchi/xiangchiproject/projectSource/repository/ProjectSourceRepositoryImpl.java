package com.xiangchi.xiangchiproject.projectSource.repository;

import com.xiangchi.xiangchiproject.common.model.PageParam;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourcePageParam;
import com.xiangchi.xiangchiproject.projectSource.model.po.ProjectSourcePo;
import com.xiangchi.xiangchiproject.projectSource.repository.mysql.ProjectSourceMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Repository
public class ProjectSourceRepositoryImpl implements ProjectSourceRepository{

    @Resource
    private ProjectSourceMapper projectSourceMapper;

    @Override
    public Long insert(ProjectSourcePo po) {
        projectSourceMapper.insert(po);
        return po.getId();
    }

    @Override
    public Long update(ProjectSourcePo po) {
        projectSourceMapper.update(po);
        return po.getId();
    }

    @Override
    public void delete(Set<Long> ids) {
        projectSourceMapper.delete(ids);
        return;
    }

    @Override
    public ProjectSourcePo queryOne(Long id) {
        return projectSourceMapper.queryOne(id);
    }

    @Override
    public List<ProjectSourcePo> pageList(ProjectSourcePageParam param) {
        if (param.getPageParam() == null) {
            param.setPageParam(PageParam.builder().pageLen(10).pageNum(0).build());
        }
        return projectSourceMapper.pageByParam(param);
    }

    @Override
    public Integer count(ProjectSourcePageParam param) {
        return projectSourceMapper.countByParam(param);
    }
}
