package com.xiangchi.xiangchiproject.customer;

import com.xiangchi.xiangchiproject.customer.dto.CustomerDto;
import com.xiangchi.xiangchiproject.customer.dto.CustomerPageDto;
import com.xiangchi.xiangchiproject.customer.param.CustomerCreateParam;
import com.xiangchi.xiangchiproject.customer.param.CustomerPageParam;
import com.xiangchi.xiangchiproject.customer.param.CustomerUpdateParam;
import com.xiangchi.xiangchiproject.utils.ResultInfo;

public interface CustomerService {

    ResultInfo<Long> createOne(CustomerCreateParam param);

    ResultInfo<Long> updateOne(CustomerUpdateParam param);

    ResultInfo deleteOne(Long id);

    ResultInfo<CustomerDto> detail(Long id);

    ResultInfo<CustomerPageDto> page(CustomerPageParam param);
}
