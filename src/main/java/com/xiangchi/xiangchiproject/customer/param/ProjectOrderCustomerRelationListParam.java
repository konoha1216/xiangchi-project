package com.xiangchi.xiangchiproject.customer.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectOrderCustomerRelationListParam {

    private Collection<Long> projectOrderIds;

    private Collection<Long> customerIds;

}
