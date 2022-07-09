package com.xiangchi.xiangchiproject.customer;

import com.xiangchi.xiangchiproject.customer.param.CustomerPageParam;
import com.xiangchi.xiangchiproject.customer.po.CustomerPo;

import java.util.List;
import java.util.Set;

public interface CustomerRepository {

    Long insertOne(CustomerPo po);

    Long updateOne(CustomerPo po);

    void deleteOne(Set<Long> ids);

    CustomerPo query(Long id);

    List<CustomerPo> page(CustomerPageParam param);

    Integer count(CustomerPageParam param);
}
