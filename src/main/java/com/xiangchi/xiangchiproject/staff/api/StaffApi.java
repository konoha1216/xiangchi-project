package com.xiangchi.xiangchiproject.staff.api;

import com.xiangchi.xiangchiproject.common.model.ApiRestResponse;
import com.xiangchi.xiangchiproject.staff.model.dto.StaffDto;
import com.xiangchi.xiangchiproject.staff.model.param.StaffLoginParam;
import com.xiangchi.xiangchiproject.staff.model.param.StaffRegistryParam;
import com.xiangchi.xiangchiproject.staff.model.param.StaffUpdateParam;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/api/staff")
public interface StaffApi {

    @GetMapping("/detail")
    ApiRestResponse<StaffDto> detail(@RequestParam("id") Long id);

    @PostMapping("/registry")
    ApiRestResponse<Long> registry(@RequestBody StaffRegistryParam param);

    @PostMapping("/login")
    ApiRestResponse<StaffDto> login(@RequestBody StaffLoginParam param, HttpSession session);

    @PostMapping("/update")
    ApiRestResponse<Long> update(@RequestBody StaffUpdateParam param, HttpSession session);

    @PostMapping("/logout")
    ApiRestResponse<String> logout(HttpSession session);
}
