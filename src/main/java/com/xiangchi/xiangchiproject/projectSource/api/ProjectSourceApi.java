package com.xiangchi.xiangchiproject.projectSource.api;

import com.xiangchi.xiangchiproject.common.model.ApiRestResponse;
import com.xiangchi.xiangchiproject.projectSource.model.dto.ProjectSourceDetailDto;
import com.xiangchi.xiangchiproject.projectSource.model.dto.ProjectSourcePageDto;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourceCreateParam;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourcePageParam;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourceUpdateParam;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/projectSource")
public interface ProjectSourceApi {

    @PostMapping("/create")
    ApiRestResponse<Long> create(@RequestBody ProjectSourceCreateParam param);

    @PostMapping("/update")
    ApiRestResponse<Long> update(@RequestBody ProjectSourceUpdateParam param);

    @DeleteMapping("/delete")
    ApiRestResponse<String> delete(@RequestParam("id") Long id);

    @GetMapping("/detail")
    ApiRestResponse<ProjectSourceDetailDto> detail(@RequestParam("id") Long id);

    @PostMapping("/page")
    ApiRestResponse<ProjectSourcePageDto> list(@RequestBody ProjectSourcePageParam param);
}
