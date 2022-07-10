package com.xiangchi.xiangchiproject.contact.param;

import com.xiangchi.xiangchiproject.common.model.PageParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactPageParam {

    private String name;

    private String code;

    private List<Long> customerIds;

    private PageParam pageParam;
}
