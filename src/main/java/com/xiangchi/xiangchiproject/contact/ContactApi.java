package com.xiangchi.xiangchiproject.contact;

import com.xiangchi.xiangchiproject.common.model.ApiRestResponse;
import com.xiangchi.xiangchiproject.contact.dto.ContactDto;
import com.xiangchi.xiangchiproject.contact.dto.ContactPageDto;
import com.xiangchi.xiangchiproject.contact.param.ContactCreateParam;
import com.xiangchi.xiangchiproject.contact.param.ContactPageParam;
import com.xiangchi.xiangchiproject.contact.param.ContactUpdateParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/contact")
public interface ContactApi {

    @PostMapping("/createOne")
    ApiRestResponse<Long> createOne(@RequestBody ContactCreateParam param);

    @PostMapping("/updateOne")
    ApiRestResponse<Long> updateOne(@RequestBody ContactUpdateParam param);

    @PostMapping("/deleteOne")
    ApiRestResponse deleteOne(@RequestParam("id") Long id);

    @PostMapping("/deleteAll")
    ApiRestResponse deleteAll(@RequestParam("ids") List<Long> ids);

    @GetMapping("/detail")
    ApiRestResponse<ContactDto> detail(@RequestParam("id") Long id);

    @PostMapping("/page")
    ApiRestResponse<ContactPageDto> page(@RequestBody ContactPageParam param);
}
