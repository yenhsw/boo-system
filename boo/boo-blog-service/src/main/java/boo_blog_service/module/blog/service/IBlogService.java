package boo_blog_service.module.blog.service;

import boo_share.common.response.PageResponse;
import boo_blog_service.module.blog.dto.*;

import java.util.UUID;

public interface IBlogService {
    PageResponse<BlogResponse> search(BlogSearchRequest request);
    BlogResponse create(CreateBlogRequest request);
    BlogResponse update(UUID id, UpdateBlogRequest request);
    void delete(UUID id);
}
