package com.house.coffee.specification;

import com.house.coffee.domainobjects.Order;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderSpecificationBuilder {

    private final List<OrderSearchCriteria> params;

    public OrderSpecificationBuilder() {
        params = new ArrayList<OrderSearchCriteria>();
    }

    public OrderSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new OrderSearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Order> build() {
        if(params.size() == 0) {
            return null;
        }

        List<Specification> specs = params.stream()
                .map(OrderSpecification::new)
                .collect(Collectors.toList());

        Specification result = specs.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }
        return result;

    }

}
