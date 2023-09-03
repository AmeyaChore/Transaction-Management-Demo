package net.javaProject.springboot.dto;

import lombok.Getter;
import lombok.Setter;
import net.javaProject.springboot.entity.Order;
import net.javaProject.springboot.entity.Payment;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
