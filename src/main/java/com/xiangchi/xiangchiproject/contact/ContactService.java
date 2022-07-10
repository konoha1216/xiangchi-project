package com.xiangchi.xiangchiproject.contact;

import com.xiangchi.xiangchiproject.contact.dto.ContactDto;
import com.xiangchi.xiangchiproject.contact.dto.ContactPageDto;
import com.xiangchi.xiangchiproject.contact.param.ContactCreateParam;
import com.xiangchi.xiangchiproject.contact.param.ContactPageParam;
import com.xiangchi.xiangchiproject.contact.param.ContactUpdateParam;
import com.xiangchi.xiangchiproject.utils.ResultInfo;

import java.util.List;

public interface ContactService {

    ResultInfo<Long> createOne(ContactCreateParam param);

    ResultInfo<Long> updateOne(ContactUpdateParam param);

    ResultInfo deleteOne(Long id);

    ResultInfo deleteAll(List<Long> ids);

    ResultInfo<ContactDto> detail(Long id);

    ResultInfo<ContactPageDto> page(ContactPageParam param);
}
