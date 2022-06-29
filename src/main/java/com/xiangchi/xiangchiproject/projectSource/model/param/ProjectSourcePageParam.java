package com.xiangchi.xiangchiproject.projectSource.model.param;

import com.xiangchi.xiangchiproject.common.model.PageParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectSourcePageParam {

    private String name;

    private String code;

    private PageParam pageParam;
}
