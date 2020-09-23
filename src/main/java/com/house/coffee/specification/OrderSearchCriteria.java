package com.house.coffee.specification;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderSearchCriteria {
    private String key;
    private  String operation;
    private Object value;

}
