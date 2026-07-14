package com.ecommerce.demo.Controller;

import com.ecommerce.demo.Entity.Orders;
import com.ecommerce.demo.Service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/buy/{userId}")
    public String placeOrder(@PathVariable Long userId){
        return orderService.placeOrder(userId);
    }

    @GetMapping("/{userId}")
    public List<Orders> getOrders(@PathVariable Long userId){
        return orderService.getOrders(userId);
    }
}
