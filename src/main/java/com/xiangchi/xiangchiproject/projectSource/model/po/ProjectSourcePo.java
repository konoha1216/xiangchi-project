package com.xiangchi.xiangchiproject.projectSource.model.po;

import com.xiangchi.xiangchiproject.projectSource.model.dto.ProjectSourceDetailDto;
import com.xiangchi.xiangchiproject.projectSource.model.param.ProjectSourceCreateParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectSourcePo {

    private Long id;

    private String name;

    private String code;

    private String comment;

    public static ProjectSourcePo convertFromCreateParam(ProjectSourceCreateParam createParam) {
        if (null == createParam) {
            return null;
        }
        return ProjectSourcePo.builder()
                .name(createParam.getName())
                .code(createParam.getCode())
                .comment(Optional.ofNullable(createParam.getComment()).orElse(Strings.EMPTY))
                .build();
    }

    public static ProjectSourceDetailDto convertToDto(ProjectSourcePo po) {
        if (null == po) {
            return null;
        }
        return ProjectSourceDetailDto.builder()
                .id(po.getId())
                .name(po.getName())
                .code(po.getCode())
                .comment(po.getComment())
                .build();
    }
}
