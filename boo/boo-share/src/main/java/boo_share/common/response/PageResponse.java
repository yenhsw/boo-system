package boo_share.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> {

    private int page;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private List<T> items;
}

