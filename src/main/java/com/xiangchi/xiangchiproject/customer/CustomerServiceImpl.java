package com.xiangchi.xiangchiproject.customer;

import com.xiangchi.xiangchiproject.common.XiangchiException;
import com.xiangchi.xiangchiproject.common.model.PageInfo;
import com.xiangchi.xiangchiproject.customer.dto.CustomerDto;
import com.xiangchi.xiangchiproject.customer.dto.CustomerPageDto;
import com.xiangchi.xiangchiproject.customer.param.CustomerCreateParam;
import com.xiangchi.xiangchiproject.customer.param.CustomerPageParam;
import com.xiangchi.xiangchiproject.customer.param.CustomerUpdateParam;
import com.xiangchi.xiangchiproject.customer.po.CustomerPo;
import com.xiangchi.xiangchiproject.utils.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{
    
    @Resource
    private CustomerRepository customerRepository;
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo<Long> createOne(CustomerCreateParam param) {
        Long id = customerRepository.insertOne(CustomerPo.convertFromCreateParam(param));
        return ResultInfo.success(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo<Long> updateOne(CustomerUpdateParam param) {
        Long id = customerRepository.updateOne(CustomerPo.convertFromUpdateParam(param));
        return ResultInfo.success(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo deleteOne(Long id) {
        customerRepository.deleteOne(Collections.singleton(id));
        return ResultInfo.success();
    }

    @Override
    public ResultInfo<CustomerDto> detail(Long id) {
        CustomerDto dto;
        try {
            CustomerPo po = customerRepository.query(id);
            dto = CustomerPo.convertToDto(po);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultInfo.error(e.getMessage());
        }
        return ResultInfo.success(dto);
    }

    @Override
    public ResultInfo<CustomerPageDto> page(CustomerPageParam param) {
        CustomerPageDto dto;
        try {
            List<CustomerPo> poList= customerRepository.page(param);
            Integer count = customerRepository.count(param);
            List<CustomerDto> listDto = poList.stream().map(CustomerPo::convertToDto).collect(Collectors.toList());
            PageInfo pageInfo = PageInfo.builder()
                    .pageLen(param.getPageParam().getPageLen())
                    .pageNum(param.getPageParam().getPageNum())
                    .recordsInTotal(count)
                    .build();
            dto = CustomerPageDto.builder().customerDtoList(listDto).pageInfo(pageInfo).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultInfo.error(e.getMessage());
        }
        return ResultInfo.success(dto);
    }
}
