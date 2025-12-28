package boo_core.module.blog.query;

import boo_share.common.response.PageResponse;
import boo_core.module.blog.dto.BlogResponse;
import boo_core.module.blog.dto.BlogSearchRequest;

public interface IBlogQueryService {
    PageResponse<BlogResponse> search(BlogSearchRequest request);
}
