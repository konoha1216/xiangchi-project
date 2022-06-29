package com.xiangchi.xiangchiproject.projectSource.model.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectSourceUpdateParam {

    private Long id;

    private String name;

    private String code;

    private String comment;
}
