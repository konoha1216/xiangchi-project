package com.xiangchi.xiangchiproject.staff.service;

import com.xiangchi.xiangchiproject.staff.model.dto.StaffDto;
import com.xiangchi.xiangchiproject.staff.model.param.StaffRegistryParam;
import com.xiangchi.xiangchiproject.staff.model.param.StaffUpdateParam;
import com.xiangchi.xiangchiproject.utils.ResultInfo;

public interface StaffService {

    StaffDto detail(Long id);

    ResultInfo<Long> registry(StaffRegistryParam param);

    ResultInfo<StaffDto> login(String code, String password);

    ResultInfo<Long> update(StaffUpdateParam param);
}
