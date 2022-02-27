package com.carles2701.TicketShop.repository;

import com.carles2701.TicketShop.model.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<Tickets, Long> {
}
