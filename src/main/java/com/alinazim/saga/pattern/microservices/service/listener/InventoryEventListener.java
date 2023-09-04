package com.alinazim.saga.pattern.microservices.service.listener;

import com.alinazim.saga.pattern.microservices.event.InventoryFailedEvent;
import com.alinazim.saga.pattern.microservices.event.PaymentProcessedEvent;
import com.alinazim.saga.pattern.microservices.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryEventListener {
    private final InventoryService inventoryService;
    private final ApplicationEventPublisher eventPublisher;

    @EventListener
    public void handlePaymentProcessedEvent(PaymentProcessedEvent event) {
        boolean inventoryUpdateSuccess = inventoryService.updateInventory(event.getOrder());

        if (!inventoryUpdateSuccess) {
            eventPublisher.publishEvent(new InventoryFailedEvent(event.getOrder()));
        }
    }
}
