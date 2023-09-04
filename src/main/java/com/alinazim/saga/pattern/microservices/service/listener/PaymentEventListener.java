package com.alinazim.saga.pattern.microservices.service.listener;

import com.alinazim.saga.pattern.microservices.event.InventoryFailedEvent;
import com.alinazim.saga.pattern.microservices.event.OrderCreatedEvent;
import com.alinazim.saga.pattern.microservices.event.PaymentFailedEvent;
import com.alinazim.saga.pattern.microservices.event.PaymentProcessedEvent;
import com.alinazim.saga.pattern.microservices.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentEventListener {

    private final ApplicationEventPublisher eventPublisher;
    private final PaymentService paymentService;

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        boolean paymentSuccess = paymentService.processPayment(event.getOrder());

        if (paymentSuccess) {
            eventPublisher.publishEvent(new PaymentProcessedEvent(event.getOrder()));
        } else {
            eventPublisher.publishEvent(new PaymentFailedEvent(event.getOrder()));
        }
    }

    @EventListener
    public void handleInventoryFailedEvent(InventoryFailedEvent event) {
        System.out.println("Payment service: Rolling back payment due to inventory update failure");
        paymentService.rollbackPayment(event.getOrder());
    }
}

