package com.xiangchi.xiangchiproject.staff.repository.mysql;

import com.xiangchi.xiangchiproject.staff.model.po.StaffPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StaffMapper {

    StaffPo queryById(@Param("id") Long id);

    StaffPo queryByCode(@Param("code") String code);

    void insert(@Param("po") StaffPo po);

    StaffPo queryByCodeAndPassWordStaffPo(@Param("code") String code, @Param("password") String password);

    void update(@Param("po") StaffPo po);
}
