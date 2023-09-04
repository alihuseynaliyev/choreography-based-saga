package com.alinazim.saga.pattern.microservices.event;

import com.alinazim.saga.pattern.microservices.model.request.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentFailedEvent {
    private final Order order;
}
