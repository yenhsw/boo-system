package boo_blog_service.module.blog;
import boo_share.common.response.ApiResponse;
import boo_share.common.response.ApiResponseUtil;
import boo_share.common.response.PageResponse;
import boo_blog_service.module.blog.dto.*;
import boo_blog_service.module.blog.service.IBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Boo!";
    }

    @PostMapping("/hello")
    public String postHello() {
        return "Hello from Boo!";
    }

    @GetMapping("/view")
    @PreAuthorize("hasAuthority('USER_VIEW')")
    public String view() {
        return "VIEW_OK";
    }

    @GetMapping("/create")
    @PreAuthorize("hasAuthority('USER_CREATE')")
    public String create() {
        return "CREATE_OK";
    }

    @GetMapping("/update")
    @PreAuthorize("hasAuthority('USER_UPDATE')")
    public String update() {
        return "UPDATE_OK";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('USER_DELETE')")
    public String delete() {
        return "DELETE_OK";
    }

    @GetMapping("/system")
    @PreAuthorize("hasAuthority('SYSTEM_MANAGE')")
    public String system() {
        return "SYSTEM_OK";
    }
}

