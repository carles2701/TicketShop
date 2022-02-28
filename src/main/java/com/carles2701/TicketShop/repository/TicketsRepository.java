package com.carles2701.TicketShop.repository;

import com.carles2701.TicketShop.model.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketsRepository extends JpaRepository<Tickets, Long> {
    List<Tickets> findAllByArtist_Id(long id);
}
