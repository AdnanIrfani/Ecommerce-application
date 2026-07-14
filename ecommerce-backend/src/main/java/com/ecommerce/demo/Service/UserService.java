package com.ecommerce.demo.Service;

import com.ecommerce.demo.Entity.Users;
import com.ecommerce.demo.Repository.UserRepository;
import com.ecommerce.demo.dto.LoginRequest;
import com.ecommerce.demo.dto.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users addUser(Users user){
        return userRepository.save(user);
    }

    public List<Users> getAllUser(){
        return userRepository.findAll();
    }

    public Users getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }

    public Users updateUser(Long id, Users user){
        Users user1 = userRepository.findById(id).orElse(null);
        if(user1 != null) {
            user1.setName(user.getName());
            user1.setEmail(user.getEmail());
            user1.setPhone(user.getPhone());
            user1.setAddress(user.getAddress());
            user1.setPassword(user.getPassword());

            return userRepository.save(user1);
        }
        return null;
    }

    public Users deleteUser(Long id){
        Users user = userRepository.findById(id).orElse(null);
        if(user != null) {
            userRepository.delete(user);
            return user;
        }
        return null;
    }


    public String register(RegisterRequest request) {

        Optional<Users> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            return "Email already exists";
        }

        Users user = new Users();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return "User Registered Successfully";
    }

    // Login User
    public Users login(LoginRequest request) {

        Optional<Users> user = userRepository.findByEmail(request.getEmail());

        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        Users user1 = user.get();

        if (!user1.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user1;
    }

}
