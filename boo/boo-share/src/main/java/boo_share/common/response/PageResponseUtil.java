package boo_share.common.response;


import java.util.List;

public final class PageResponseUtil {

    private PageResponseUtil() {}

    public static <R> PageResponse<R> from(
            int page,
            int pageSize,
            long totalElements,
            List<R> items
    ) {
        int totalPages = (int) Math.ceil((double) totalElements / pageSize);

        return PageResponse.<R>builder()
                .page(page)
                .pageSize(pageSize)
                .totalElements(totalElements)
                .totalPages(totalPages)
                .items(items)
                .build();
    }
}