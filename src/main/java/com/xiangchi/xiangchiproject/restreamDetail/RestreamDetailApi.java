package com.xiangchi.xiangchiproject.restreamDetail;

import com.xiangchi.xiangchiproject.common.model.ApiRestResponse;
import com.xiangchi.xiangchiproject.restreamDetail.dto.RestreamDetailPageDto;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailCreateParam;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailPageParam;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailUpdateParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/restreamDetail")
public interface RestreamDetailApi {

    @PostMapping("/createOne")
    ApiRestResponse<Long> createOne(@RequestBody RestreamDetailCreateParam param);

    @PostMapping("/updateOne")
    ApiRestResponse<Long> updateOne(@RequestBody RestreamDetailUpdateParam param);

    @PostMapping("/deleteOne")
    ApiRestResponse deleteOne(@RequestParam("id") Long id);

    @PostMapping("/page")
    ApiRestResponse<RestreamDetailPageDto> page(@RequestBody RestreamDetailPageParam param);
}
