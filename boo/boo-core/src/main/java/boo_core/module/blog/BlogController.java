package boo_core.module.blog;
import boo_share.common.response.ApiResponse;
import boo_share.common.response.ApiResponseUtil;
import boo_share.common.response.PageResponse;
import boo_core.module.blog.dto.*;
import boo_core.module.blog.service.IBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/api/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final IBlogService blogService;

    @PostMapping("/search")
    public ApiResponse<PageResponse<BlogResponse>> search(
            @RequestBody BlogSearchRequest request
    ) {
        return ApiResponseUtil.success(
                blogService.search(request)
        );
    }

    @PostMapping
    public ApiResponse<BlogResponse> create(
            @RequestBody CreateBlogRequest request
    ) {
        return ApiResponseUtil.created(
                blogService.create(request)
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<BlogResponse> update(
            @PathVariable UUID id,
            @RequestBody UpdateBlogRequest request
    ) {
        return ApiResponseUtil.success(
                blogService.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable UUID id) {
        blogService.delete(id);
        return ApiResponseUtil.noContent();
    }
}
