package boo_core.module.blog.mapper;

import boo_core.module.blog.dto.BlogResponse;
import boo_core.persistence.entity.BlogEntity;
import org.springframework.stereotype.Component;

@Component
public class BlogMapper {

    public BlogResponse toResponse(BlogEntity entity) {
        return BlogResponse.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }
}