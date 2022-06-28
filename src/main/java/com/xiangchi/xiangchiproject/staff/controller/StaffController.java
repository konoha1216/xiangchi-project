package com.xiangchi.xiangchiproject.staff.controller;

import com.xiangchi.xiangchiproject.common.ApiRestResponse;
import com.xiangchi.xiangchiproject.common.Constant;
import com.xiangchi.xiangchiproject.common.ResponseCodeEnum;
import com.xiangchi.xiangchiproject.staff.api.StaffApi;
import com.xiangchi.xiangchiproject.staff.model.dto.StaffDto;
import com.xiangchi.xiangchiproject.staff.model.param.StaffLoginParam;
import com.xiangchi.xiangchiproject.staff.model.param.StaffRegistryParam;
import com.xiangchi.xiangchiproject.staff.model.param.StaffUpdateParam;
import com.xiangchi.xiangchiproject.staff.service.StaffService;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@Slf4j
public class StaffController implements StaffApi {

    @Resource
    private StaffService staffService;

    @Override
    public ApiRestResponse detail(Long id) {
        if (id == null) {
            return  ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST);
        }
        return ApiRestResponse.success(staffService.detail(id));
    }

    @Override
    public ApiRestResponse<Long> registry(StaffRegistryParam param) {
        ResultInfo<String> checkResult = param.check();
        if (!checkResult.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.FORBIDDEN, checkResult.getMessage());
        }
        ResultInfo<Long> registryResult = staffService.registry(param);
        if (!registryResult.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, registryResult.getMessage());
        }
        return ApiRestResponse.success(registryResult.getData());
    }

    @Override
    public ApiRestResponse<StaffDto> login(StaffLoginParam param, HttpSession session) {
        ResultInfo<String> checkResult = param.check();
        if (!checkResult.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.FORBIDDEN, checkResult.getMessage());
        }
        ResultInfo<StaffDto> staffDtoResult = staffService.login(param.getCode(), param.getPassword());
        if (!staffDtoResult.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, staffDtoResult.getMessage());
        }
        session.setAttribute(Constant.XIANGCHI_STAFF, staffDtoResult.getData());
        return ApiRestResponse.success(staffDtoResult.getData());
    }

    @Override
    public ApiRestResponse<Long> update(StaffUpdateParam param, HttpSession session) {
        ResultInfo<String> checkResult = param.check();
        if (!checkResult.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.FORBIDDEN, checkResult.getMessage());
        }
        ResultInfo<Long> updateResult = staffService.update(param);
        if (!updateResult.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, updateResult.getMessage());
        }
        return ApiRestResponse.success(updateResult.getData());
    }

    @Override
    public ApiRestResponse<String> logout(HttpSession session) {
        session.removeAttribute(Constant.XIANGCHI_STAFF);
        return ApiRestResponse.success();
    }
}
