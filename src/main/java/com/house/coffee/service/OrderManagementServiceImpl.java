package com.house.coffee.service;

import com.house.coffee.domainobjects.Item;
import com.house.coffee.domainobjects.Order;
import com.house.coffee.exception.OrderNotFoundException;
import com.house.coffee.repository.ItemRepository;
import com.house.coffee.repository.OrderRepository;

import com.house.coffee.specification.OrderSpecificationBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		return orderRepository.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException(" Order with id ["+ orderId +"] not found "));
	}

	@Override
	public List<Order> searchOrder(String criteria) {
		return orderRepository.findAll(createSpecification(criteria));
	}

	private Specification<Order> createSpecification(String criteria) {
		// criteria  => customerId:1;status:created

		OrderSpecificationBuilder builder = new OrderSpecificationBuilder();
		Pattern pattern = Pattern.compile("(\\w+?)(:)(\\w+?),");
		Matcher matcher = pattern.matcher(criteria + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		return builder.build();
	}

	@Override
	public Order updateOrder(Long id, Order order) {
		return null;
	}

	@Override
	public void cancelOrder(Long orderId) {
		// TODO set order status CANCELLED
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
