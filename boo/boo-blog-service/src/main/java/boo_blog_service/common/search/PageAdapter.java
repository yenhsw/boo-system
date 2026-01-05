package boo_blog_service.common.search;


import boo_share.common.response.PageResponse;
import boo_share.common.response.PageResponseUtil;
import org.springframework.data.domain.Page;

import java.util.function.Function;

public final class PageAdapter {

    private PageAdapter() {}

    public static <T, R> PageResponse<R> from(
            Page<T> page,
            Function<T, R> mapper
    ) {
        return PageResponseUtil.from(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getContent()
                        .stream()
                        .map(mapper)
                        .toList()
        );
    }
}