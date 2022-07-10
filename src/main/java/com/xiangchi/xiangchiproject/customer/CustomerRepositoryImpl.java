package com.xiangchi.xiangchiproject.customer;

import com.xiangchi.xiangchiproject.common.model.PageParam;
import com.xiangchi.xiangchiproject.customer.mysql.CustomerMapper;
import com.xiangchi.xiangchiproject.customer.param.CustomerPageParam;
import com.xiangchi.xiangchiproject.customer.po.CustomerPo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Long insertOne(CustomerPo po) {
        customerMapper.insert(po);
        return po.getId();
    }

    @Override
    public Long updateOne(CustomerPo po) {
        customerMapper.update(po);
        return po.getId();
    }

    @Override
    public void deleteOne(Set<Long> ids) {
        customerMapper.delete(ids);
        return;
    }

    @Override
    public CustomerPo query(Long id) {
        return customerMapper.query(id);
    }

    @Override
    public List<CustomerPo> list(Set<Long> ids) {
        return customerMapper.list(ids);
    }

    @Override
    public List<CustomerPo> page(CustomerPageParam param) {
        if (param.getPageParam() == null) {
            param.setPageParam(PageParam.builder().pageLen(10).pageNum(0).build());
        }
        return customerMapper.pageByParam(param);
    }

    @Override
    public Integer count(CustomerPageParam param) {
        return customerMapper.countByParam(param);
    }
}
