package boo_blog_service.module.blog.command;

import boo_blog_service.module.blog.dto.BlogResponse;
import boo_blog_service.module.blog.dto.CreateBlogRequest;
import boo_blog_service.module.blog.dto.UpdateBlogRequest;

import java.util.UUID;

public interface IBlogCommandService {
    BlogResponse create(CreateBlogRequest request);
    BlogResponse update(UUID id, UpdateBlogRequest request);
    void delete(UUID id);
}
