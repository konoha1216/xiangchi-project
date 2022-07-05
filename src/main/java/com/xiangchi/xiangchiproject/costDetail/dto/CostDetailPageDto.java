package com.xiangchi.xiangchiproject.costDetail.dto;

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
public class CostDetailPageDto {

    private List<CostDetailDto>  costDetailDtoList;

    private PageInfo pageInfo;

}
