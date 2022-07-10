package com.xiangchi.xiangchiproject.customer.bo;

import com.xiangchi.xiangchiproject.contact.dto.ContactDto;
import com.xiangchi.xiangchiproject.contact.po.ContactPo;
import com.xiangchi.xiangchiproject.customer.po.CustomerPo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContactCreator {

    public static List<ContactDto> buildContactList(List<ContactPo> poList,
                                                    Map<Long, CustomerPo> customerIdMap) {
        List<ContactDto> result = new ArrayList<>();
        poList.forEach(e -> {
            ContactDto contactDto = ContactDto.builder()
                    .id(e.getId())
                    .name(e.getName())
                    .code(e.getCode())
                    .phone(e.getPhone())
                    .email(e.getEmail())
                    .build();
            if (null != customerIdMap) {
                contactDto.setCustomerDto(CustomerPo.convertToDto(customerIdMap.get(e.getId())));
            }
            result.add(contactDto);
        });
        return result;
    }
}
