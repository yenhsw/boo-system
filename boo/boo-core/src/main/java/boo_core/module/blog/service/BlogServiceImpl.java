package boo_core.module.blog.service;

import boo_core.module.blog.command.IBlogCommandService;
import boo_core.module.blog.query.IBlogQueryService;
import boo_share.common.response.PageResponse;
import boo_core.module.blog.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements IBlogService {

    private final IBlogQueryService queryService;
    private final IBlogCommandService commandService;

    @Override
    public PageResponse<BlogResponse> search(BlogSearchRequest request) {
        return queryService.search(request);
    }

    @Override
    public BlogResponse create(CreateBlogRequest request) {
        return commandService.create(request);
    }

    @Override
    public BlogResponse update(UUID id, UpdateBlogRequest request) {
        return commandService.update(id, request);
    }

    @Override
    public void delete(UUID id) {
        commandService.delete(id);
    }
}
