package com.xiangchi.xiangchiproject.customer.mysql;

import com.xiangchi.xiangchiproject.customer.param.CustomerPageParam;
import com.xiangchi.xiangchiproject.customer.po.CustomerPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface CustomerMapper {

    void insert(@Param("po") CustomerPo po);

    void update(@Param("po") CustomerPo po);

    void delete(Set<Long> ids);

    CustomerPo query(Long id);

    List<CustomerPo> list(Set<Long> ids);

    List<CustomerPo> pageByParam(@Param("param") CustomerPageParam param);

    Integer countByParam(@Param("param") CustomerPageParam param);
}
