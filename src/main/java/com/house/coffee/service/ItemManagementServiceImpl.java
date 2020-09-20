package com.house.coffee.service;

import com.house.coffee.domainobjects.Item;
import com.house.coffee.domainobjects.Order;
import com.house.coffee.repository.ItemRepository;
import com.house.coffee.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemManagementServiceImpl implements ItemManagementService{


    private OrderRepository orderRepository;


}
