package com.xiangchi.xiangchiproject.staff.repository;

import com.xiangchi.xiangchiproject.staff.model.po.StaffPo;

public interface StaffRepository {

    StaffPo detail(Long id);

    StaffPo getStaffByCode(String code);

    Long create(StaffPo staffPo);

    StaffPo getStaffByCodeAndPassword(String code, String password);

    void update(StaffPo staffPo);
}
