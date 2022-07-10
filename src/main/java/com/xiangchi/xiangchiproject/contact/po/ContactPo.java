package com.xiangchi.xiangchiproject.contact.po;

import com.xiangchi.xiangchiproject.contact.dto.ContactDto;
import com.xiangchi.xiangchiproject.contact.param.ContactCreateParam;
import com.xiangchi.xiangchiproject.contact.param.ContactUpdateParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactPo {
    
    private Long id;
    
    private String name;
    
    private String code;

    private String phone;

    private String email;

    private Long customerId;
    
    private String comment;
    
    private Integer isDeleted;
    
    public static ContactPo convertFromCreateParam(ContactCreateParam createParam) {
        if (null == createParam) {
            return null;
        }
        return ContactPo.builder()
                .name(createParam.getName())
                .code(createParam.getCode())
                .phone(Optional.ofNullable(createParam.getPhone()).orElse(Strings.EMPTY))
                .email(Optional.ofNullable(createParam.getEmail()).orElse(Strings.EMPTY))
                .customerId(createParam.getCustomerId())
                .comment(Optional.ofNullable(createParam.getComment()).orElse(Strings.EMPTY))
                .build();
    }

    public static ContactPo convertFromUpdateParam(ContactUpdateParam updateParam) {
        if (null == updateParam) {
            return null;
        }
        return ContactPo.builder()
                .id(updateParam.getId())
                .name(updateParam.getName())
                .code(updateParam.getCode())
                .phone(Optional.ofNullable(updateParam.getPhone()).orElse(Strings.EMPTY))
                .email(Optional.ofNullable(updateParam.getEmail()).orElse(Strings.EMPTY))
                .comment(Optional.ofNullable(updateParam.getComment()).orElse(Strings.EMPTY))
                .build();
    }

    public static ContactDto convertToDto(ContactPo po) {
        if (null == po) {
            return null;
        }
        return ContactDto.builder()
                .id(po.getId())
                .name(po.getName())
                .code(po.getCode())
                .phone(po.getPhone())
                .email(po.getEmail())
                .comment(po.getComment())
                .build();
    }
    
}
