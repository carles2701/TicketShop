package com.carles2701.TicketShop.service;

import com.carles2701.TicketShop.entity.Ticket;
import com.carles2701.TicketShop.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    TicketsRepository ticketsRepository;

    public List<Ticket> getAllTickets(){
        return ticketsRepository.findAll();
    }
    public void addTicket(Ticket ticket){
        ticketsRepository.save(ticket);
    }
    public void removeTicketById(int id){
        ticketsRepository.deleteById(id);
    }
    public Optional<Ticket> getTicketById(int id){
        return ticketsRepository.findById(id);
    }
    public List<Ticket>getAllTicketsByArtistId(int id){
        return ticketsRepository.findAllByArtist_Id(id);
    }
}
