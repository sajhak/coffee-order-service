package com.house.coffee.controller;

import com.house.coffee.domainobjects.Item;
import com.house.coffee.domainobjects.Order;
import com.house.coffee.service.ItemManagementService;
import com.house.coffee.service.OrderManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemServiceController {

    Logger logger = LoggerFactory.getLogger(ItemServiceController.class);

    private OrderManagementService orderManagementService;

    @Autowired
    public ItemServiceController(OrderManagementService orderManagementService) {
        this.orderManagementService = orderManagementService;
    }

    @PostMapping("/orders/{orderId}/items")
    public Item addItem(@RequestBody Item item, @PathVariable Long orderId) {
        logger.info(" Adding Item [{}] for Order [{}] ", item, orderId);
        return orderManagementService.createItem(item, orderId);
    }
}
