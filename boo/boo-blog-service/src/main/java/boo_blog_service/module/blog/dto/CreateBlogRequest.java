package boo_blog_service.module.blog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBlogRequest {
    private String code;
    private String name;
}
