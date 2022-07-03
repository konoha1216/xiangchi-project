package com.xiangchi.xiangchiproject.projectSource.service;

import com.xiangchi.xiangchiproject.common.model.PageInfo;
import com.xiangchi.xiangchiproject.projectSource.model.dto.ProjectSourceDetailDto;
import com.xiangchi.xiangchiproject.projectSource.model.dto.ProjectSourcePageDto;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourceCreateParam;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourcePageParam;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourceUpdateParam;
import com.xiangchi.xiangchiproject.projectSource.model.po.ProjectSourcePo;
import com.xiangchi.xiangchiproject.projectSource.repository.ProjectSourceRepository;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectSourceServiceImpl implements ProjectSourceService{

    @Resource
    ProjectSourceRepository projectSourceRepository;

    @Override
    public ResultInfo<Long> create(ProjectSourceCreateParam param) {
        ProjectSourcePo projectSourcePo = ProjectSourcePo.convertFromCreateParam(param);
        return ResultInfo.success(projectSourceRepository.insert(projectSourcePo));
    }

    @Override
    public ResultInfo<Long> update(ProjectSourceUpdateParam param) {
        ProjectSourcePo projectSourcePo = ProjectSourcePo.convertFromUpdateParam(param);
        return ResultInfo.success(projectSourceRepository.update(projectSourcePo));
    }

    @Override
    public ResultInfo delete(Set<Long> ids) {
        projectSourceRepository.delete(ids);
        return ResultInfo.success();
    }

    @Override
    public ResultInfo<ProjectSourceDetailDto> detail(Long id) {
        ProjectSourcePo po = projectSourceRepository.queryOne(id);
        return ResultInfo.success(ProjectSourcePo.convertToDto(po));
    }

    @Override
    public ResultInfo<ProjectSourcePageDto> page(ProjectSourcePageParam param) {
        List<ProjectSourcePo> listPo = projectSourceRepository.pageList(param);
        Integer count = projectSourceRepository.count(param);
        List<ProjectSourceDetailDto> listDto = listPo.stream().map(ProjectSourcePo::convertToDto).collect(Collectors.toList());
        PageInfo pageInfo = PageInfo.builder()
                .pageLen(param.getPageParam().getPageLen())
                .pageNum(param.getPageParam().getPageNum())
                .recordsInTotal(count)
                .build();
        return ResultInfo.success(ProjectSourcePageDto.builder().sourceDetailDtoList(listDto).pageInfo(pageInfo).build());
    }
}
