package com.xiangchi.xiangchiproject.projectSource.model.dto;

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
public class ProjectSourcePageDto {

    private List<ProjectSourceDetailDto> sourceDetailDtoList;

    private PageInfo pageInfo;
}
