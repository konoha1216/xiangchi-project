package com.xiangchi.xiangchiproject.contact;

import com.xiangchi.xiangchiproject.common.model.PageParam;
import com.xiangchi.xiangchiproject.contact.mysql.ContactMapper;
import com.xiangchi.xiangchiproject.contact.param.ContactPageParam;
import com.xiangchi.xiangchiproject.contact.po.ContactPo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Repository
public class ContactRepositoryImpl implements ContactRepository {
    
    @Resource
    private ContactMapper contactMapper;

    @Override
    public Long insertOne(ContactPo po) {
        contactMapper.insert(po);
        return po.getId();
    }

    @Override
    public Long updateOne(ContactPo po) {
        contactMapper.update(po);
        return po.getId();
    }

    @Override
    public void delete(Set<Long> ids) {
        contactMapper.delete(ids);
        return;
    }

    @Override
    public ContactPo query(Long id) {
        return contactMapper.query(id);
    }

    @Override
    public List<ContactPo> page(ContactPageParam param) {
        if (param.getPageParam() == null) {
            param.setPageParam(PageParam.builder().pageLen(10).pageNum(0).build());
        }
        return contactMapper.pageByParam(param);
    }

    @Override
    public Integer count(ContactPageParam param) {
        return contactMapper.countByParam(param);
    }
}
