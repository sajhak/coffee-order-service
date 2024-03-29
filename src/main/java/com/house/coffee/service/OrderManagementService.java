package com.house.coffee.service;

import com.house.coffee.domainobjects.Item;
import com.house.coffee.domainobjects.Order;

import java.util.List;

public interface OrderManagementService {
     
     Order createOrder(Order order);
     Order getOrder(Long orderId);
     List<Order> searchOrder(String criteria);
     Order updateOrder(Long orderId, Order order);
     void cancelOrder(Long orderId);
     Item createItem(Item item, Long orderId);
     Item getItem(Long itemId);
     Item updateItem(Long itemId, Item item);

}
