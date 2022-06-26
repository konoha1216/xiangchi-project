package com.xiangchi.xiangchiproject.staff.repository.impl;

import com.xiangchi.xiangchiproject.staff.model.po.StaffPo;
import com.xiangchi.xiangchiproject.staff.repository.StaffRepository;
import com.xiangchi.xiangchiproject.staff.repository.mysql.StaffMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class StaffRepositoryImpl implements StaffRepository {

    @Resource
    private StaffMapper staffMapper;

    @Override
    public StaffPo detail(Long id) {
        return staffMapper.queryById(id);
    }

    @Override
    public StaffPo getStaffByCode(String code) {
        return staffMapper.queryByCode(code);
    }

    @Override
    public Long create(StaffPo staffPo) {
        staffMapper.insert(staffPo);
        return staffPo.getId();
    }

    @Override
    public StaffPo getStaffByCodeAndPassword(String code, String password) {
        return staffMapper.queryByCodeAndPassWordStaffPo(code, password);
    }

    @Override
    public void update(StaffPo staffPo) {
        staffMapper.update(staffPo);
    }
}
