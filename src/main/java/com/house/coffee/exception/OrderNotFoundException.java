package com.house.coffee.exception;

import com.house.coffee.controller.OrderServiceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not found")
public class OrderNotFoundException extends RuntimeException {

    Logger logger = LoggerFactory.getLogger(OrderNotFoundException.class);

    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
