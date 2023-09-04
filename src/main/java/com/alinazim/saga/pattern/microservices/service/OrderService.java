package com.alinazim.saga.pattern.microservices.service;

import com.alinazim.saga.pattern.microservices.event.OrderCreatedEvent;
import com.alinazim.saga.pattern.microservices.model.request.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ApplicationEventPublisher eventPublisher;

    public void createOrder(@RequestBody Order order) {
        System.out.println("Create order: " + LocalDateTime.now() + " " + order.getId());
        eventPublisher.publishEvent(new OrderCreatedEvent(order));
    }
}
