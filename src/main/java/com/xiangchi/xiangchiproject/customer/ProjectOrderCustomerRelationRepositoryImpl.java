package com.xiangchi.xiangchiproject.customer;

import com.xiangchi.xiangchiproject.customer.mysql.ProjectOrderCustomerRelationMapper;
import com.xiangchi.xiangchiproject.customer.param.ProjectOrderCustomerRelationListParam;
import com.xiangchi.xiangchiproject.customer.po.ProjectOrderCustomerRelationPo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ProjectOrderCustomerRelationRepositoryImpl implements ProjectOrderCustomerRelationRepository{

    @Resource
    private ProjectOrderCustomerRelationMapper projectOrderCustomerRelationMapper;

    @Override
    public List<Long> create(List<ProjectOrderCustomerRelationPo> poList) {
        projectOrderCustomerRelationMapper.insertAll(new HashSet<>(poList));
        return poList.stream().map(ProjectOrderCustomerRelationPo::getId).collect(Collectors.toList());
    }

    @Override
    public void delete(Set<Long> ids) {
        projectOrderCustomerRelationMapper.deleteAll(ids);
    }

    @Override
    public List<ProjectOrderCustomerRelationPo> list(ProjectOrderCustomerRelationListParam param) {
        return projectOrderCustomerRelationMapper.list(param);
    }
}
