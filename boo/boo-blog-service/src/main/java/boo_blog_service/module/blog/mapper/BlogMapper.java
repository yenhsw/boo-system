package boo_blog_service.module.blog.mapper;

import boo_blog_service.module.blog.dto.BlogResponse;
import boo_blog_service.persistence.entity.BlogEntity;
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