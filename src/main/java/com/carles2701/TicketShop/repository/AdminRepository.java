package com.carles2701.TicketShop.repository;

import com.carles2701.TicketShop.model.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Long, Admins> {
}
