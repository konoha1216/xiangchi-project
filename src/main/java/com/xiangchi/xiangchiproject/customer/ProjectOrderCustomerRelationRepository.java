package com.xiangchi.xiangchiproject.customer;

import com.xiangchi.xiangchiproject.customer.param.ProjectOrderCustomerRelationListParam;
import com.xiangchi.xiangchiproject.customer.po.ProjectOrderCustomerRelationPo;

import java.util.List;
import java.util.Set;

public interface ProjectOrderCustomerRelationRepository {

    List<Long> create(List<ProjectOrderCustomerRelationPo> poList);

    void delete(Set<Long> ids);

    List<ProjectOrderCustomerRelationPo> list(ProjectOrderCustomerRelationListParam param);
}
