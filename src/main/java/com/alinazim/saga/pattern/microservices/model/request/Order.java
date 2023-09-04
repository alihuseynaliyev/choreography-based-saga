package com.alinazim.saga.pattern.microservices.model.request;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private String item;
    private Integer quantity;
}
