package com.xiangchi.xiangchiproject.contact.dto;

import com.xiangchi.xiangchiproject.customer.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

    private Long id;

    private String name;

    private String code;

    private String phone;

    private String email;

    private String comment;

    private CustomerDto customerDto;
}
