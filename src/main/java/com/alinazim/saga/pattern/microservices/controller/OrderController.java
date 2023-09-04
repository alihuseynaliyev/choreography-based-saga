package com.alinazim.saga.pattern.microservices.controller;

import com.alinazim.saga.pattern.microservices.model.request.Order;
import com.alinazim.saga.pattern.microservices.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createOrder(@RequestBody Order order){
        orderService.createOrder(order);
    }
}
