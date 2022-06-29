package com.xiangchi.xiangchiproject.projectSource.controller;

import com.xiangchi.xiangchiproject.common.model.ApiRestResponse;
import com.xiangchi.xiangchiproject.common.model.ResponseCodeEnum;
import com.xiangchi.xiangchiproject.projectSource.api.ProjectSourceApi;
import com.xiangchi.xiangchiproject.projectSource.model.dto.ProjectSourceDetailDto;
import com.xiangchi.xiangchiproject.projectSource.model.dto.ProjectSourcePageDto;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourceCreateParam;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourcePageParam;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourceUpdateParam;
import com.xiangchi.xiangchiproject.projectSource.service.ProjectSourceService;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProjectSourceController implements ProjectSourceApi {

    @Resource
    private ProjectSourceService projectSourceService;
    @Override
    public ApiRestResponse<Long> create(ProjectSourceCreateParam param) {
        if (null == param) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<String> checkInfo = param.check();
        if (!checkInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, checkInfo.getMessage());
        }
        ResultInfo<Long> createResult = projectSourceService.create(param);
        if (!createResult.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, createResult.getMessage());
        }
        return ApiRestResponse.success(createResult.getData());

    }

    @Override
    public ApiRestResponse<Long> update(ProjectSourceUpdateParam param) {
        return null;
    }

    @Override
    public ApiRestResponse<String> delete(Long id) {
        return null;
    }

    @Override
    public ApiRestResponse<ProjectSourceDetailDto> detail(Long id) {
        return null;
    }

    @Override
    public ApiRestResponse<ProjectSourcePageDto> list(ProjectSourcePageParam param) {
        return null;
    }
}
