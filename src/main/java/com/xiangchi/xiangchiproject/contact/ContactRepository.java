package com.xiangchi.xiangchiproject.contact;


import com.xiangchi.xiangchiproject.contact.param.ContactPageParam;
import com.xiangchi.xiangchiproject.contact.po.ContactPo;

import java.util.List;
import java.util.Set;

public interface ContactRepository {

    Long insertOne(ContactPo po);

    Long updateOne(ContactPo po);

    void delete(Set<Long> ids);

    ContactPo query(Long id);

    List<ContactPo> page(ContactPageParam param);

    Integer count(ContactPageParam param);
}
