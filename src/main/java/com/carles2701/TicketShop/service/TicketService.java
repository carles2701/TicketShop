package com.carles2701.TicketShop.service;

import com.carles2701.TicketShop.model.Tickets;
import com.carles2701.TicketShop.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    TicketsRepository ticketsRepository;

    public List<Tickets> getAllTickets(){
        return ticketsRepository.findAll();
    }
    public void addTicket(Tickets ticket){
        ticketsRepository.save(ticket);
    }
    public void removeTicketById(long id){
        ticketsRepository.deleteById(id);
    }
    public Optional<Tickets> getTicketById(long id){
        return ticketsRepository.findById(id);
    }
    public List<Tickets>getAllTicketsByArtistId(long id){
        return ticketsRepository.findAllByArtist_Id(id);
    }
}
