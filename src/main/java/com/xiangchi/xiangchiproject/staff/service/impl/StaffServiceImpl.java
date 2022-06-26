package com.xiangchi.xiangchiproject.staff.service.impl;

import com.xiangchi.xiangchiproject.staff.model.dto.StaffDto;
import com.xiangchi.xiangchiproject.staff.model.param.StaffRegistryParam;
import com.xiangchi.xiangchiproject.staff.model.param.StaffUpdateParam;
import com.xiangchi.xiangchiproject.staff.model.po.StaffPo;
import com.xiangchi.xiangchiproject.staff.repository.StaffRepository;
import com.xiangchi.xiangchiproject.staff.service.StaffService;
import com.xiangchi.xiangchiproject.utils.MD5Utils;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffRepository staffRepository;

    @Override
    public StaffDto detail(Long id) {
        StaffPo staffPo = staffRepository.detail(id);
        return StaffPo.convertToDto(staffPo);
    }

    @Override
    public ResultInfo<Long> registry(StaffRegistryParam param) {
        String code = param.getCode();
        StaffPo oldStaff = staffRepository.getStaffByCode(code);
        if (null != oldStaff) {
            return ResultInfo.error("员工编号重复，注册失败");
        }
        // 密码存入数据库前加密
        param.setPassword(MD5Utils.getMD5Str(param.getPassword()));
        StaffPo registryStaffPo = StaffPo.convertFromRegistryParam(param);
        Long id = staffRepository.create(registryStaffPo);
        return ResultInfo.success(id);
    }

    @Override
    public ResultInfo<StaffDto> login(String code, String password) {
        String newPassword = MD5Utils.getMD5Str(password);
        StaffPo staffPo = staffRepository.getStaffByCodeAndPassword(code, newPassword);
        if (null == staffPo) {
            return ResultInfo.error("未找到匹配用户，登录失败");
        }
        return ResultInfo.success(StaffPo.convertToDto(staffPo));
    }

    @Override
    public ResultInfo<Long> update(StaffUpdateParam param) {
        StaffPo staffPo = staffRepository.detail(param.getId());
        if (null == staffPo) {
            return ResultInfo.error("此用户不存在，更新失败");
        }
        StaffPo staffByCode = staffRepository.getStaffByCode(param.getCode());
        if (null != staffByCode && !Objects.equals(staffByCode.getId(), param.getId())) {
            return ResultInfo.error("此用户编号已存在，更新失败");
        }
        if (StringUtils.hasLength(param.getName())) {
            staffPo.setName(param.getName());
        }
        if (StringUtils.hasLength(param.getCode())) {
            staffPo.setCode(param.getCode());
        }
        if (StringUtils.hasLength(param.getPhone())) {
            staffPo.setPhone(param.getPhone());
        }
        if (StringUtils.hasLength(param.getEmail())) {
            staffPo.setEmail(param.getEmail());
        }
        if (StringUtils.hasLength(param.getComment())) {
            staffPo.setComment(param.getComment());
        }
        staffRepository.update(staffPo);
        return ResultInfo.success(staffPo.getId());
    }
}
