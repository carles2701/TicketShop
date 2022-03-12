package com.carles2701.TicketShop.repository;

import com.carles2701.TicketShop.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketsRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findAllByArtist_Id(int id);
}
