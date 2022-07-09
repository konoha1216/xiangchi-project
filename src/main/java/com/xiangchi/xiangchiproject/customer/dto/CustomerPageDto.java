package com.xiangchi.xiangchiproject.customer.dto;

import com.xiangchi.xiangchiproject.common.model.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPageDto {

    private List<CustomerDto> customerDtoList;

    private PageInfo pageInfo;
}
