package com.xiangchi.xiangchiproject.costDetail;

import com.xiangchi.xiangchiproject.common.model.ApiRestResponse;
import com.xiangchi.xiangchiproject.costDetail.dto.CostDetailPageDto;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailCreateParam;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailPageParam;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailUpdateParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/costDetail")
public interface CostDetailApi {

    @PostMapping("/createOne")
    ApiRestResponse<Long> createOne(@RequestBody CostDetailCreateParam param);

    @PostMapping("/updateOne")
    ApiRestResponse<Long> updateOne(@RequestBody CostDetailUpdateParam param);

    @PostMapping("/deleteOne")
    ApiRestResponse deleteOne(@RequestParam("id") Long id);

    @PostMapping("/page")
    ApiRestResponse<CostDetailPageDto> page(@RequestBody CostDetailPageParam param);
}
