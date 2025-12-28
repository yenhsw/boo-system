package boo_core.common.search;

import boo_share.common.search.SearchCriteria;
import boo_share.common.search.SearchOperator;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SearchSpecificationBuilder<T> {

    private final List<Specification<T>> specs = new ArrayList<>();

    public SearchSpecificationBuilder<T> orLike(
            List<String> fields,
            String value
    ) {
        if (value == null || value.isBlank()) {
            return this;
        }

        Specification<T> orSpec = null;

        for (String field : fields) {
            Specification<T> spec =
                    new SearchSpecification<>(
                            new SearchCriteria(field, value, SearchOperator.LIKE)
                    );

            orSpec = (orSpec == null) ? spec : orSpec.or(spec);
        }

        if (orSpec != null) {
            specs.add(orSpec);
        }

        return this;
    }

    public Specification<T> build() {
        if (specs.isEmpty()) {
            return null;
        }

        Specification<T> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = result.and(specs.get(i));
        }
        return result;
    }
}