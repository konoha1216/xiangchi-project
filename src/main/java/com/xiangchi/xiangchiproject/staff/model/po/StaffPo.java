package com.xiangchi.xiangchiproject.staff.model.po;

import com.xiangchi.xiangchiproject.staff.model.dto.StaffDto;
import com.xiangchi.xiangchiproject.staff.model.param.StaffRegistryParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffPo {

    private Long id;

    private String name;

    private String code;

    private String passWord;

    private String phone;

    private String email;

    private String comment;

    private Integer isAdmin;

    private Integer isVisit;

    private Integer isDeleted;

    public static StaffDto convertToDto(StaffPo po) {
        if (null == po) {
            return null;
        }
        return StaffDto.builder()
                .id(po.getId())
                .name(po.getName())
                .code(po.getCode())
                .phone(po.getPhone())
                .email(po.getEmail())
                .comment(po.getComment())
                .isAdmin(po.getIsAdmin())
                .isVisit(po.getIsVisit())
                .build();
    }

    public static StaffPo convertFromRegistryParam(StaffRegistryParam param) {
        if (null == param){
            return null;
        }
        return StaffPo.builder()
                .name(param.getName())
                .code(param.getCode())
                .passWord(param.getPassword())
                .phone(null == param.getPhone() ? Strings.EMPTY : param.getPhone())
                .email(null == param.getEmail() ? Strings.EMPTY : param.getEmail())
                .comment(null == param.getComment() ? Strings.EMPTY : param.getComment())
                .isAdmin(null == param.getIsAdmin() ? 0 : param.getIsAdmin())
                .isVisit(null == param.getIsVisit() ? 0 : param.getIsVisit())
                .build();
    }
}
