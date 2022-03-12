package com.carles2701.TicketShop.service;

import com.carles2701.TicketShop.model.User;
import com.carles2701.TicketShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public void removeUserById(int id){
        userRepository.deleteById(id);
    }
    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }
}
