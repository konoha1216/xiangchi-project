package com.xiangchi.xiangchiproject.restreamDetail;

import com.xiangchi.xiangchiproject.common.model.ApiRestResponse;
import com.xiangchi.xiangchiproject.common.model.ResponseCodeEnum;
import com.xiangchi.xiangchiproject.restreamDetail.dto.RestreamDetailPageDto;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailCreateParam;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailPageParam;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailUpdateParam;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RestreamDetailController implements RestreamDetailApi{
    
    @Resource
    private RestreamDetailService restreamDetailService;

    @Override
    public ApiRestResponse<Long> createOne(RestreamDetailCreateParam param) {
        if (param == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<String> resultInfo = param.check();
        if (!resultInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, resultInfo.getMessage());
        }
        ResultInfo<Long> createInfo = restreamDetailService.createOne(param);
        if (!createInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, createInfo.getMessage());
        }
        return ApiRestResponse.success(createInfo.getData());
    }

    @Override
    public ApiRestResponse<Long> updateOne(RestreamDetailUpdateParam param) {
        if (param == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<String> resultInfo = param.check();
        if (!resultInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, resultInfo.getMessage());
        }
        ResultInfo<Long> updateInfo = restreamDetailService.updateOne(param);
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
        ResultInfo deleteInfo = restreamDetailService.deleteOne(id);
        if (!deleteInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, deleteInfo.getMessage());
        }
        return ApiRestResponse.success();
    }

    @Override
    public ApiRestResponse<RestreamDetailPageDto> page(RestreamDetailPageParam param) {
        if (param == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<String> resultInfo = param.check();
        if (!resultInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, resultInfo.getMessage());
        }
        ResultInfo<RestreamDetailPageDto> pageInfo = restreamDetailService.page(param);
        if (!pageInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, pageInfo.getMessage());
        }
        return ApiRestResponse.success(pageInfo.getData());
    }
}
