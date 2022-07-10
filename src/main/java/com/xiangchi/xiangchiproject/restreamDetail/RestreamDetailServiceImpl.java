package com.xiangchi.xiangchiproject.restreamDetail;

import com.xiangchi.xiangchiproject.common.model.PageInfo;
import com.xiangchi.xiangchiproject.restreamDetail.dto.RestreamDetailDto;
import com.xiangchi.xiangchiproject.restreamDetail.po.RestreamDetailPo;
import com.xiangchi.xiangchiproject.restreamDetail.dto.RestreamDetailPageDto;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailCreateParam;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailPageParam;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailUpdateParam;
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
public class RestreamDetailServiceImpl implements RestreamDetailService{
    
    @Resource
    private RestreamDetailRepository restreamDetailRepository;
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo<Long> createOne(RestreamDetailCreateParam param) {
        Long id = restreamDetailRepository.insertOne(RestreamDetailPo.convertFromCreateParam(param));
        return ResultInfo.success(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo<Long> updateOne(RestreamDetailUpdateParam param) {
        Long id = restreamDetailRepository.updateOne(RestreamDetailPo.convertFromUpdateParam(param));
        return ResultInfo.success(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo deleteOne(Long id) {
        restreamDetailRepository.deleteOne(Collections.singleton(id));
        return ResultInfo.success();
    }

    @Override
    public ResultInfo<RestreamDetailPageDto> page(RestreamDetailPageParam param) {
        RestreamDetailPageDto dto;
        try {
            List<RestreamDetailPo> poList= restreamDetailRepository.page(param);
            Integer count = restreamDetailRepository.count(param);
            List<RestreamDetailDto> listDto = poList.stream().map(RestreamDetailPo::convertToDto).collect(Collectors.toList());
            PageInfo pageInfo = PageInfo.builder()
                    .pageLen(param.getPageParam().getPageLen())
                    .pageNum(param.getPageParam().getPageNum())
                    .recordsInTotal(count)
                    .build();
            dto = RestreamDetailPageDto.builder().restreamDetailDtoList(listDto).pageInfo(pageInfo).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultInfo.error(e.getMessage());
        }
        return ResultInfo.success(dto);
    }
}
