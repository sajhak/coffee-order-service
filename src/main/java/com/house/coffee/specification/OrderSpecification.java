package com.house.coffee.specification;

import com.house.coffee.domainobjects.Order;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class OrderSpecification implements Specification<Order> {

    private OrderSearchCriteria orderSearchCriteria;

    public OrderSpecification(final OrderSearchCriteria orderSearchCriteria) {
        super();
        this.orderSearchCriteria = orderSearchCriteria;
    }


    @Override
    public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (orderSearchCriteria.getOperation().equals(":")) {
            if (root.get(orderSearchCriteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.like(root.<String>get(orderSearchCriteria.getKey()), "%" + orderSearchCriteria.getValue() + "%");
            } else {
                return criteriaBuilder.equal(root.get(orderSearchCriteria.getKey()), orderSearchCriteria.getValue());
            }
        }
        return null;
    }
}
