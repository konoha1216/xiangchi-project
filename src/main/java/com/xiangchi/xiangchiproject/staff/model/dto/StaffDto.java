package com.xiangchi.xiangchiproject.staff.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto {

    private Long id;

    private String name;

    private String code;

    private String phone;

    private String email;

    private String comment;

    private Integer isAdmin;

    private Integer isVisit;
}
