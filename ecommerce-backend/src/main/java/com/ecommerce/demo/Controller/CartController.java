package com.ecommerce.demo.Controller;

import com.ecommerce.demo.Entity.Cart;
import com.ecommerce.demo.Service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long userId,
                          @RequestParam Long itemId,
                          @RequestParam int quantity){

        return cartService.addToCart(userId,itemId,quantity);
    }

    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable Long userId){
        return cartService.getCart(userId);
    }

    @DeleteMapping("/{cartId}")
    public String removeItem(@PathVariable Long cartId){

        cartService.removeItem(cartId);

        return "Item Removed";
    }
}

