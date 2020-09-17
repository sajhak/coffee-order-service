package com.house.coffee.service;

import com.house.coffee.domainobjects.Order;
import com.house.coffee.repository.OrderRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManagementServiceImpl implements OrderManagementService {

	private final OrderRepository orderRepository;

	public OrderManagementServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order getOrder(Long orderId) {
		return orderRepository.findById(orderId).orElseGet(Order::new);
	}

	@Override
	public List<Order> searchOrder(String criteria) {
		return null;
	}

	@Override
	public Order updateOrder(Long id, Order order) {
		return null;
	}

	@Override
	public void cancelOrder(Long orderId) {

	}

}
