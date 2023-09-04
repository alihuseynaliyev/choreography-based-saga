package com.alinazim.saga.pattern.microservices.service;

import com.alinazim.saga.pattern.microservices.model.request.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    public boolean processPayment(Order order) {
        // Payment logic
        return true;
    }

    public void rollbackPayment(Order order) {
        // Rollback payment logic
        System.out.println("Payment for order " + order.getId() + " has been rolled back.");
    }
}
