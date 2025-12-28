package boo_share.common.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class SearchRequest {

    private Integer page = 0;
    private Integer pageSize = 10;

    private String searchKey;
}