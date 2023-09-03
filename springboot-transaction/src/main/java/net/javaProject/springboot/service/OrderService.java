package net.javaProject.springboot.service;

import net.javaProject.springboot.dto.OrderRequest;
import net.javaProject.springboot.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
