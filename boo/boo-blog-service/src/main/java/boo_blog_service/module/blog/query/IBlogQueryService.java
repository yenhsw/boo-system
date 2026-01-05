package boo_blog_service.module.blog.query;

import boo_share.common.response.PageResponse;
import boo_blog_service.module.blog.dto.BlogResponse;
import boo_blog_service.module.blog.dto.BlogSearchRequest;

public interface IBlogQueryService {
    PageResponse<BlogResponse> search(BlogSearchRequest request);
}
