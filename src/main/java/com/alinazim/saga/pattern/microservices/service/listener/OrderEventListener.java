package com.alinazim.saga.pattern.microservices.service.listener;

import com.alinazim.saga.pattern.microservices.event.InventoryFailedEvent;
import com.alinazim.saga.pattern.microservices.event.PaymentFailedEvent;
import com.alinazim.saga.pattern.microservices.model.request.Order;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventListener {
    @EventListener
    public void handlePaymentFailedEvent(PaymentFailedEvent event) {
        System.out.println("Order service: Rolling back order due to payment failure");
        rollbackOrder(event.getOrder());
    }

    @EventListener
    public void handleInventoryFailedEvent(InventoryFailedEvent event) {
        System.out.println("Order service: Rolling back order due to inventory failure");
        rollbackOrder(event.getOrder());
    }

    private void rollbackOrder(Order order) {
        // Rollback logic
        System.out.println("Order " + order.getId() + " has been rolled back.");
    }
}