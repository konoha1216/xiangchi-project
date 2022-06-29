package com.xiangchi.xiangchiproject.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo {

    private Integer recordsInTotal;

    private Integer pageNum;

    private Integer pageLen;
}
