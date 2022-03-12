package com.carles2701.TicketShop.repository;

import com.carles2701.TicketShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
