package boo_blog_service.common.search;

import boo_share.common.search.SearchCriteria;
import boo_share.common.search.SearchOperator;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.*;
public class SearchSpecification<T> implements Specification<T> {

    private final SearchCriteria criteria;

    public SearchSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(
            Root<T> root,
            CriteriaQuery<?> query,
            CriteriaBuilder cb
    ) {
        return switch (criteria.getOperator()) {
            case LIKE -> cb.like(
                    cb.lower(root.get(criteria.getField())),
                    "%" + criteria.getValue().toString().toLowerCase() + "%"
            );
            case EQUAL -> cb.equal(
                    root.get(criteria.getField()),
                    criteria.getValue()
            );
        };
    }
}