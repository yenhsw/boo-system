package boo_blog_service.module.blog.query;

import boo_blog_service.common.search.PageAdapter;
import boo_blog_service.common.search.SearchSpecificationBuilder;
import boo_blog_service.module.blog.dto.BlogResponse;
import boo_blog_service.module.blog.dto.BlogSearchRequest;
import boo_blog_service.module.blog.mapper.BlogMapper;
import boo_blog_service.persistence.entity.BlogEntity;
import boo_blog_service.persistence.repository.BlogRepository;
import boo_blog_service.util.PageUtil;
import boo_share.common.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogQueryServiceImpl implements IBlogQueryService {

    private static final List<String> SEARCH_FIELDS =
            List.of("name", "code");

    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    @Override
    public PageResponse<BlogResponse> search(BlogSearchRequest request) {

        SearchSpecificationBuilder<BlogEntity> builder =
                new SearchSpecificationBuilder<>();

        builder.orLike(SEARCH_FIELDS, request.getSearchKey());

        Pageable pageable = PageUtil.pageable(
                request.getPage(),
                request.getPageSize(),
                "name",
                1
        );

        return PageAdapter.from(
                blogRepository.findAll(builder.build(), pageable),
                blogMapper::toResponse
        );
    }
}
