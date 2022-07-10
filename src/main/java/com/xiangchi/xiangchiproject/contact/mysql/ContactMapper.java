package com.xiangchi.xiangchiproject.contact.mysql;

import com.xiangchi.xiangchiproject.contact.param.ContactPageParam;
import com.xiangchi.xiangchiproject.contact.po.ContactPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface ContactMapper {

    void insert(@Param("po") ContactPo po);

    void update(@Param("po") ContactPo po);

    void delete(Set<Long> ids);

    ContactPo query(Long id);

    List<ContactPo> pageByParam(@Param("param") ContactPageParam param);

    Integer countByParam(@Param("param") ContactPageParam param);
}
