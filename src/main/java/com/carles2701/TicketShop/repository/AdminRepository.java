package com.carles2701.TicketShop.repository;

import com.carles2701.TicketShop.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
