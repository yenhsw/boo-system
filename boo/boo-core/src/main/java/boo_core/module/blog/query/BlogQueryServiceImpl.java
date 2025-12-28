package boo_core.module.blog.query;

import boo_core.common.search.PageAdapter;
import boo_core.common.search.SearchSpecificationBuilder;
import boo_core.module.blog.dto.BlogResponse;
import boo_core.module.blog.dto.BlogSearchRequest;
import boo_core.module.blog.mapper.BlogMapper;
import boo_core.persistence.entity.BlogEntity;
import boo_core.persistence.repository.BlogRepository;
import boo_core.util.PageUtil;
import boo_share.common.response.PageResponse;
import boo_share.common.response.PageResponseUtil;
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
