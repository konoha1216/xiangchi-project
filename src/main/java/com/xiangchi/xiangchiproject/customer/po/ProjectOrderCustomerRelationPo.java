package com.xiangchi.xiangchiproject.customer.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectOrderCustomerRelationPo {

    private Long id;

    private Long projectOrderId;

    private Long customerId;

    private String comment;

    private Integer isDeleted;
}
