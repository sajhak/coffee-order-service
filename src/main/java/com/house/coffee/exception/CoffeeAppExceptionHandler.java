package com.house.coffee.exception;

import com.house.coffee.controller.OrderServiceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CoffeeAppExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(CoffeeAppExceptionHandler.class);

    @ExceptionHandler(value = {OrderNotFoundException.class})
    protected ResponseEntity<Object> handleError(RuntimeException ex, WebRequest req) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        logger.error(" Exception occurred : " + ex.getMessage(), ex);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
