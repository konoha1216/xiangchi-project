package com.xiangchi.xiangchiproject.contact;

import com.xiangchi.xiangchiproject.common.model.ApiRestResponse;
import com.xiangchi.xiangchiproject.common.model.ResponseCodeEnum;
import com.xiangchi.xiangchiproject.contact.dto.ContactDto;
import com.xiangchi.xiangchiproject.contact.dto.ContactPageDto;
import com.xiangchi.xiangchiproject.contact.param.ContactCreateParam;
import com.xiangchi.xiangchiproject.contact.param.ContactPageParam;
import com.xiangchi.xiangchiproject.contact.param.ContactUpdateParam;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ContactController implements ContactApi {

    @Resource
    private ContactService contactService;

    @Override
    public ApiRestResponse<Long> createOne(ContactCreateParam param) {
        if (param == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<String> resultInfo = param.check();
        if (!resultInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, resultInfo.getMessage());
        }
        ResultInfo<Long> createInfo = contactService.createOne(param);
        if (!createInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, createInfo.getMessage());
        }
        return ApiRestResponse.success(createInfo.getData());
    }

    @Override
    public ApiRestResponse<Long> updateOne(ContactUpdateParam param) {
        if (param == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<String> resultInfo = param.check();
        if (!resultInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, resultInfo.getMessage());
        }
        ResultInfo<Long> updateInfo = contactService.updateOne(param);
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
        ResultInfo deleteInfo = contactService.deleteOne(id);
        if (!deleteInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, deleteInfo.getMessage());
        }
        return ApiRestResponse.success();
    }

    @Override
    public ApiRestResponse deleteAll(List<Long> ids) {
        if (ids == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo deleteInfo = contactService.deleteAll(ids);
        if (!deleteInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, deleteInfo.getMessage());
        }
        return ApiRestResponse.success();
    }

    @Override
    public ApiRestResponse<ContactDto> detail(Long id) {
        if (id == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<ContactDto> detailInfo = contactService.detail(id);
        if (!detailInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, detailInfo.getMessage());
        }
        return ApiRestResponse.success(detailInfo.getData());
    }

    @Override
    public ApiRestResponse<ContactPageDto> page(ContactPageParam param) {
        if (param == null) {
            return ApiRestResponse.error(ResponseCodeEnum.BAD_REQUEST, "参数不能为空");
        }
        ResultInfo<ContactPageDto> pageInfo = contactService.page(param);
        if (!pageInfo.isRight()) {
            return ApiRestResponse.error(ResponseCodeEnum.INTERNAL_SERVER_ERROR, pageInfo.getMessage());
        }
        return ApiRestResponse.success(pageInfo.getData());
    }
}
