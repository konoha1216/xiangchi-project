package com.xiangchi.xiangchiproject.customer;

import com.xiangchi.xiangchiproject.common.model.ApiRestResponse;
import com.xiangchi.xiangchiproject.customer.dto.CustomerDto;
import com.xiangchi.xiangchiproject.customer.dto.CustomerPageDto;
import com.xiangchi.xiangchiproject.customer.param.CustomerCreateParam;
import com.xiangchi.xiangchiproject.customer.param.CustomerPageParam;
import com.xiangchi.xiangchiproject.customer.param.CustomerUpdateParam;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/customer")
public interface CustomerApi {

    @PostMapping("/createOne")
    ApiRestResponse<Long> createOne(@RequestBody CustomerCreateParam param);

    @PostMapping("/updateOne")
    ApiRestResponse<Long> updateOne(@RequestBody CustomerUpdateParam param);

    @PostMapping("/deleteOne")
    ApiRestResponse deleteOne(@RequestParam("id") Long id);

    @GetMapping("/detail")
    ApiRestResponse<CustomerDto> detail(@RequestParam("id") Long id);

    @PostMapping("/page")
    ApiRestResponse<CustomerPageDto> page(@RequestBody CustomerPageParam param);

}
