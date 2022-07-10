package com.xiangchi.xiangchiproject.contact;

import com.xiangchi.xiangchiproject.common.model.PageInfo;
import com.xiangchi.xiangchiproject.contact.dto.ContactDto;
import com.xiangchi.xiangchiproject.contact.dto.ContactPageDto;
import com.xiangchi.xiangchiproject.contact.param.ContactCreateParam;
import com.xiangchi.xiangchiproject.contact.param.ContactPageParam;
import com.xiangchi.xiangchiproject.contact.param.ContactUpdateParam;
import com.xiangchi.xiangchiproject.contact.po.ContactPo;
import com.xiangchi.xiangchiproject.customer.CustomerRepository;
import com.xiangchi.xiangchiproject.customer.bo.ContactCreator;
import com.xiangchi.xiangchiproject.customer.po.CustomerPo;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {
    
    @Resource
    private ContactRepository contactRepository;
    @Resource
    private CustomerRepository customerRepository;
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo<Long> createOne(ContactCreateParam param) {
        Long id = contactRepository.insertOne(ContactPo.convertFromCreateParam(param));
        return ResultInfo.success(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo<Long> updateOne(ContactUpdateParam param) {
        Long id = contactRepository.updateOne(ContactPo.convertFromUpdateParam(param));
        return ResultInfo.success(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo deleteOne(Long id) {
        contactRepository.delete(Collections.singleton(id));
        return ResultInfo.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo deleteAll(List<Long> ids) {
        contactRepository.delete(new HashSet<>(ids));
        return ResultInfo.success();
    }

    @Override
    public ResultInfo<ContactDto> detail(Long id) {
        ContactDto dto;
        try {
            ContactPo po = contactRepository.query(id);
            CustomerPo customerPo = customerRepository.query(po.getCustomerId());
            dto = ContactPo.convertToDto(po);
            dto.setCustomerDto(CustomerPo.convertToDto(customerPo));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultInfo.error(e.getMessage());
        }
        return ResultInfo.success(dto);
    }

    @Override
    public ResultInfo<ContactPageDto> page(ContactPageParam param) {
        ContactPageDto dto;
        try {
            List<ContactPo> poList= contactRepository.page(param);
            Integer count = contactRepository.count(param);
            if (count == 0) {
                return ResultInfo.success();
            }
            // 然后要查一下他们所属的客户信息
            Set<Long> customerIds = poList.stream().map(ContactPo::getCustomerId).collect(Collectors.toSet());
            List<CustomerPo> customerPoList = customerRepository.list(customerIds);
            Map<Long, CustomerPo> customerIdMap = customerPoList.stream().collect(Collectors.toMap(CustomerPo::getId, po -> po));
            List<ContactDto> listDto = ContactCreator.buildContactList(poList, customerIdMap);
            PageInfo pageInfo = PageInfo.builder()
                    .pageLen(param.getPageParam().getPageLen())
                    .pageNum(param.getPageParam().getPageNum())
                    .recordsInTotal(count)
                    .build();
            dto = ContactPageDto.builder().contactDtoList(listDto).pageInfo(pageInfo).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultInfo.error(e.getMessage());
        }
        return ResultInfo.success(dto);
    }
}
