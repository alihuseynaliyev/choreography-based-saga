package com.alinazim.saga.pattern.microservices.service;

import com.alinazim.saga.pattern.microservices.model.request.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    public boolean updateInventory(Order order) {
        // Inventory updated logic
        return false;
    }
}
