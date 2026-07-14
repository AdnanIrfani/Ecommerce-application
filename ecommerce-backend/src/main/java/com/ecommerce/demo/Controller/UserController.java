package com.ecommerce.demo.Controller;

import com.ecommerce.demo.Entity.Users;
import com.ecommerce.demo.Service.UserService;
import com.ecommerce.demo.dto.LoginRequest;
import com.ecommerce.demo.dto.RegisterRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Users addUser(@RequestBody Users user){
        return userService.addUser(user);
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id,@RequestBody Users user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public Users deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }


    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request) {

        return userService.register(request);
    }

    @PostMapping("/login")
    public Users loginUser(@RequestBody LoginRequest request) {

        return userService.login(request);
    }
}
