package boo_share.common.search;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SearchCriteria {

    private String field;
    private Object value;
    private SearchOperator operator;
}
