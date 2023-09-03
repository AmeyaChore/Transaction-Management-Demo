package net.javaProject.springboot.service.impl;

import net.javaProject.springboot.dto.OrderRequest;
import net.javaProject.springboot.dto.OrderResponse;
import net.javaProject.springboot.entity.Order;
import net.javaProject.springboot.entity.Payment;
import net.javaProject.springboot.exception.PaymentException;
import net.javaProject.springboot.repository.OrderRepository;
import net.javaProject.springboot.repository.PaymentRepository;
import net.javaProject.springboot.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    //private ModelMapper mapper;
    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository ;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order=orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment=orderRequest.getPayment();

        //only supporting payment card type DEBIT not credit and COD(cash on Delivery)
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not Support");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);
        OrderResponse orderResponse=new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESSFUL");
        return orderResponse;
    }
}
