package com.xiangchi.xiangchiproject.customer.po;

import com.xiangchi.xiangchiproject.customer.dto.CustomerDto;
import com.xiangchi.xiangchiproject.customer.param.CustomerCreateParam;
import com.xiangchi.xiangchiproject.customer.param.CustomerUpdateParam;
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
public class CustomerPo {
    
    private Long id;
    
    private String name;
    
    private String code;
    
    private String comment;
    
    private Integer isDeleted;
    
    public static CustomerPo convertFromCreateParam(CustomerCreateParam createParam) {
        if (null == createParam) {
            return null;
        }
        return CustomerPo.builder()
                .name(createParam.getName())
                .code(createParam.getCode())
                .comment(Optional.ofNullable(createParam.getComment()).orElse(Strings.EMPTY))
                .build();
    }

    public static CustomerPo convertFromUpdateParam(CustomerUpdateParam updateParam) {
        if (null == updateParam) {
            return null;
        }
        return CustomerPo.builder()
                .id(updateParam.getId())
                .name(updateParam.getName())
                .code(updateParam.getCode())
                .comment(Optional.ofNullable(updateParam.getComment()).orElse(Strings.EMPTY))
                .build();
    }

    public static CustomerDto convertToDto(CustomerPo po) {
        if (null == po) {
            return null;
        }
        return CustomerDto.builder()
                .id(po.getId())
                .name(po.getName())
                .code(po.getCode())
                .comment(po.getComment())
                .build();
    }
    
}
