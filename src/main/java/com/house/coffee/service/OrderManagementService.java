package com.house.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.house.coffee.domainobjects.Order;
import com.house.coffee.repository.OrderRepository;

@Component
public class OrderManagementService {

	@Autowired
	private OrderRepository orderRepository;
	
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}
	
	
}
