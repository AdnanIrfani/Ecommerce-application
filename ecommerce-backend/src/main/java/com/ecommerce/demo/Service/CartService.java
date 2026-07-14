package com.ecommerce.demo.Service;

import com.ecommerce.demo.Entity.Cart;
import com.ecommerce.demo.Entity.Items;
import com.ecommerce.demo.Entity.Users;
import com.ecommerce.demo.Repository.CartRepository;
import com.ecommerce.demo.Repository.ItemRepository;
import com.ecommerce.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public CartService(CartRepository cartRepository, UserRepository userRepository, ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    public Cart addToCart(Long userId, Long itemId, int quantity) {

        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Items item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setItem(item);
        cart.setQuantity(quantity);
            return cartRepository.save(cart);
        }

        public List<Cart> getCart(Long userId){
            return cartRepository.findByUserId(userId);
        }

        public void removeItem(Long cartId){
            cartRepository.deleteById(cartId);
        }


}


