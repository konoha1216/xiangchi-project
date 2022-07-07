package com.xiangchi.xiangchiproject.restreamDetail.dto;

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
public class RestreamDetailPageDto {

    private List<RestreamDetailDto> restreamDetailDtoList;

    private PageInfo pageInfo;
}
