package com.xiangchi.xiangchiproject.customer;

import com.xiangchi.xiangchiproject.common.model.ApiRestResponse;
import com.xiangchi.xiangchiproject.common.model.ResponseCodeEnum;
import com.xiangchi.xiangchiproject.customer.dto.CustomerDto;
import com.xiangchi.xiangchiproject.customer.dto.CustomerPageDto;
import com.xiangchi.xiangchiproject.customer.param.CustomerCreateParam;
import com.xiangchi.xiangchiproject.customer.param.CustomerPageParam;
import com.xiangchi.xiangchiproject.customer.param.CustomerUpdateParam;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CustomerController implements CustomerApi{

    @Resource
    private CustomerService customerService;

    @Override
    public ApiRestResponse<Long> createOne(CustomerCreateParam param) {
        if (param == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<String> resultInfo = param.check();
        if (!resultInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, resultInfo.getMessage());
        }
        ResultInfo<Long> createInfo = customerService.createOne(param);
        if (!createInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, createInfo.getMessage());
        }
        return ApiRestResponse.success(createInfo.getData());
    }

    @Override
    public ApiRestResponse<Long> updateOne(CustomerUpdateParam param) {
        if (param == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<String> resultInfo = param.check();
        if (!resultInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, resultInfo.getMessage());
        }
        ResultInfo<Long> updateInfo = customerService.updateOne(param);
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
        ResultInfo deleteInfo = customerService.deleteOne(id);
        if (!deleteInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, deleteInfo.getMessage());
        }
        return ApiRestResponse.success();
    }

    @Override
    public ApiRestResponse<CustomerDto> detail(Long id) {
        if (id == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<CustomerDto> detailInfo = customerService.detail(id);
        if (!detailInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, detailInfo.getMessage());
        }
        return ApiRestResponse.success(detailInfo.getData());
    }

    @Override
    public ApiRestResponse<CustomerPageDto> page(CustomerPageParam param) {
        if (param == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<CustomerPageDto> pageInfo = customerService.page(param);
        if (!pageInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, pageInfo.getMessage());
        }
        return ApiRestResponse.success(pageInfo.getData());
    }
}
