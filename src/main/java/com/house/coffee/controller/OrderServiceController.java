package com.house.coffee.controller;

import com.house.coffee.domainobjects.Order;
import com.house.coffee.service.OrderManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderServiceController {

    Logger logger = LoggerFactory.getLogger(OrderServiceController.class);

    private final OrderManagementService orderManagementService;

    @Autowired
    public OrderServiceController(OrderManagementService orderManagementService) {
        this.orderManagementService = orderManagementService;
    }

    @PostMapping("/orders")
    public Order placeOrder(@RequestBody Order order) {
        logger.info(" Creating Order {}", order);
        return orderManagementService.createOrder(order);
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable Long id) {
        logger.info(" Get Order of id {}", id);
        return orderManagementService.getOrder(id);
    }

    @GetMapping("/orders/search")
    public List<Order> searchOrders(@RequestParam String pattern) {
        logger.info(" Search Order with search pattern {}", pattern);
        return orderManagementService.searchOrder(pattern);
    }

    @PutMapping("/orders/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order newOrder) {
        logger.info(" Update Order id {} with new order {}", id, newOrder);
        return orderManagementService.updateOrder(id, newOrder);
    }

}
