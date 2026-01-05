package boo_blog_service.util;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public final class PageUtil {

    private PageUtil() {}

    public static Pageable pageable(
            Integer page,
            Integer size,
            String sortField,
            int sortOrder
    ) {
        int safePage = page != null && page >= 0 ? page : 0;
        int safeSize = size != null && size > 0 ? size : 10;

        Sort.Direction direction =
                sortOrder < 0 ? Sort.Direction.DESC : Sort.Direction.ASC;

        Sort sort = Sort.by(direction, sortField);

        return PageRequest.of(safePage, safeSize, sort);
    }
}
