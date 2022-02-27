package com.carles2701.TicketShop.service;

import com.carles2701.TicketShop.model.Users;
import com.carles2701.TicketShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }
    public void addUser(Users user){
        userRepository.save(user);
    }
    public void removeUserById(long id){
        userRepository.deleteById(id);
    }
    public Optional<Users> getUserById(long id){
        return userRepository.findById(id);
    }
}
