package com.xiangchi.xiangchiproject.costDetail;

import com.xiangchi.xiangchiproject.common.model.ApiRestResponse;
import com.xiangchi.xiangchiproject.common.model.ResponseCodeEnum;
import com.xiangchi.xiangchiproject.costDetail.dto.CostDetailPageDto;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailCreateParam;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailPageParam;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailUpdateParam;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CostDetailController implements CostDetailApi{

    @Resource
    private CostDetailService costDetailService;

    @Override
    public ApiRestResponse<Long> createOne(CostDetailCreateParam param) {
        if (param == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<String> resultInfo = param.check();
        if (!resultInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, resultInfo.getMessage());
        }
        ResultInfo<Long> createInfo = costDetailService.createOne(param);
        if (!createInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, createInfo.getMessage());
        }
        return ApiRestResponse.success(createInfo.getData());
    }

    @Override
    public ApiRestResponse<Long> updateOne(CostDetailUpdateParam param) {
        if (param == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<String> resultInfo = param.check();
        if (!resultInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, resultInfo.getMessage());
        }
        ResultInfo<Long> updateInfo = costDetailService.updateOne(param);
        if (!updateInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, updateInfo.getMessage());
        }
        return ApiRestResponse.success(updateInfo.getData());
    }

    @Override
    public ApiRestResponse deleteOne(Long id) {
        if (id == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo deleteInfo = costDetailService.deleteOne(id);
        if (!deleteInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, deleteInfo.getMessage());
        }
        return ApiRestResponse.success();
    }

    @Override
    public ApiRestResponse<CostDetailPageDto> page(CostDetailPageParam param) {
        if (param == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<String> resultInfo = param.check();
        if (!resultInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, resultInfo.getMessage());
        }
        ResultInfo<CostDetailPageDto> pageInfo = costDetailService.page(param);
        if (!pageInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, pageInfo.getMessage());
        }
        return ApiRestResponse.success(pageInfo.getData());
    }
}
