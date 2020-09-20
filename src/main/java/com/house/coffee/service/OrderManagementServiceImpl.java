package com.house.coffee.service;

import com.house.coffee.domainobjects.Item;
import com.house.coffee.domainobjects.Order;
import com.house.coffee.repository.ItemRepository;
import com.house.coffee.repository.OrderRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderManagementServiceImpl implements OrderManagementService {

	private final OrderRepository orderRepository;
	private ItemRepository itemRepository;

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

	@Override
	public Item createItem(Item item, Long orderId) {
		Order order = orderRepository.findById(orderId).get();
		item.setOrder(order);
		return itemRepository.save(item);
	}

	@Override
	public Item getItem(Long itemId) {
		return null;
	}

	@Override
	public Item updateItem(Long itemId, Item item) {
		return null;
	}

}
