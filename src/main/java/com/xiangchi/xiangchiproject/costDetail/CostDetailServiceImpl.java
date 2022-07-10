package com.xiangchi.xiangchiproject.costDetail;

import com.xiangchi.xiangchiproject.common.model.PageInfo;
import com.xiangchi.xiangchiproject.costDetail.dto.CostDetailDto;
import com.xiangchi.xiangchiproject.costDetail.dto.CostDetailPageDto;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailCreateParam;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailPageParam;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailUpdateParam;
import com.xiangchi.xiangchiproject.costDetail.po.CostDetailPo;
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
public class CostDetailServiceImpl implements CostDetailService{

    @Resource
    private CostDetailRepository costDetailRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultInfo<Long> createOne(CostDetailCreateParam param) {
        Long id = costDetailRepository.insertOne(CostDetailPo.convertFromCreateParam(param));
        return ResultInfo.success(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultInfo<Long> updateOne(CostDetailUpdateParam param) {
        Long id = costDetailRepository.updateOne(CostDetailPo.convertFromUpdateParam(param));
        return ResultInfo.success(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultInfo deleteOne(Long id) {
        costDetailRepository.deleteOne(Collections.singleton(id));
        return ResultInfo.success();
    }

    @Override
    public ResultInfo<CostDetailPageDto> page(CostDetailPageParam param) {
        CostDetailPageDto dto;
        try {
            List<CostDetailPo> poList= costDetailRepository.page(param);
            Integer count = costDetailRepository.count(param);
            List<CostDetailDto> listDto = poList.stream().map(CostDetailPo::convertToDto).collect(Collectors.toList());
            PageInfo pageInfo = PageInfo.builder()
                    .pageLen(param.getPageParam().getPageLen())
                    .pageNum(param.getPageParam().getPageNum())
                    .recordsInTotal(count)
                    .build();
            dto = CostDetailPageDto.builder().costDetailDtoList(listDto).pageInfo(pageInfo).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultInfo.error(e.getMessage());
        }
        return ResultInfo.success(dto);
    }
}
