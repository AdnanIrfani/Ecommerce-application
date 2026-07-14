package com.ecommerce.demo.Service;

import com.ecommerce.demo.Entity.Cart;
import com.ecommerce.demo.Entity.OrderItem;
import com.ecommerce.demo.Entity.Orders;
import com.ecommerce.demo.Entity.Users;
import com.ecommerce.demo.Repository.CartRepository;
import com.ecommerce.demo.Repository.OrderItemRepository;
import com.ecommerce.demo.Repository.OrderRepository;
import com.ecommerce.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, CartRepository cartRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public String placeOrder(Long userId){
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<Cart> cartItems = cartRepository.findByUserId(userId);
        if(cartItems.isEmpty()){
            return "Cart is Empty";
        }
        double total = 0;
        for(Cart cart : cartItems){
            total += cart.getItem().getPrice() * cart.getQuantity();
        }
        Orders order = new Orders();
        order.setUser(user);
        order.setOrderDate(LocalDate.now());
        order.setTotalAmount(total);
        orderRepository.save(order);
        for(Cart cart : cartItems){
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setItem(cart.getItem());
            orderItem.setQuantity(cart.getQuantity());
            orderItem.setPrice(cart.getItem().getPrice());
            orderItemRepository.save(orderItem);
        }
        cartRepository.deleteAll(cartItems);
        return "Order Placed Successfully";
    }

    public List<Orders> getOrders(Long userId){
        return orderRepository.findByUserId(userId);
    }

}
