package com.carles2701.TicketShop.controller;

import com.carles2701.TicketShop.model.Artist;
import com.carles2701.TicketShop.model.Ticket;
import com.carles2701.TicketShop.service.ArtistService;
import com.carles2701.TicketShop.service.TicketService;
import com.carles2701.TicketShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    ArtistService artistService;

    @Autowired
    TicketService ticketService;

    @Autowired
    UserService userService;


    @GetMapping("/admin")
    public String adminHomePage(){
        return "adminPage";
    }

    @GetMapping("/admin/artists")
    public String getArtists(Model model){
        model.addAttribute("artists", artistService.getAllArtists());
        return "artistPage";
    }

    @GetMapping("/admin/artists/add")
    public String getArtistsAdd(Model model){
        model.addAttribute("artist", new Artist());
        return "artistAddPage";
    }

    @PostMapping("/admin/artists/add")
    public String postArtistsAdd(@ModelAttribute("artist") Artist artist){
        artistService.addArtist(artist);
        return "redirect:/admin/artists";
    }

    @GetMapping("/admin/artists/delete/{id}")
    public String deleteArtist(@PathVariable int id){
        artistService.removeArtistById(id);
        return "redirect:/admin/artists";
    }

    @GetMapping("/admin/artists/update/{id}")
    public String updateArtist(@PathVariable int id, Model model){
        Artist artist = artistService.getArtistById(id).get();
        artist.setId(artist.getId());
        artist.setGenre(artist.getGenre());
        artist.setKnownAs(artist.getKnownAs());
        artistService.addArtist(artist);
        return "redirect:/admin/artists";
    }

    @GetMapping("/admin/users")
    public String getUsers(Model model){
        model.addAttribute("existing_users", userService.getAllUsers());
        return "userPage";
    }

    @GetMapping("/admin/users/delete/{id}")
    public String deleteUser(@PathVariable int id){
        userService.removeUserById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/tickets")
    public String getTickets(Model model){
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "ticketPage";
    }

    @GetMapping("/admin/tickets/add")
    public String getAddTicket(Model model){
        model.addAttribute("tickets", new Ticket());
        return "ticketAddPage";
    }

    @PostMapping("/admin/tickets/add")
    public String postAddTicket(@ModelAttribute("ticket") Ticket ticket){
        ticketService.addTicket(ticket);
        return "redirect:/admin/tickets";
    }

    @GetMapping("/admin/ticket/update/{id}")
    public String updateTicket(@PathVariable int id, Model model){
        Ticket ticket = ticketService.getTicketById(id).get();
        ticket.setId(ticket.getId());
        ticket.setArtist(ticket.getArtist());
        ticket.setDate_year(ticket.getDate_year());
        ticket.setDate_month(ticket.getDate_month());
        ticket.setDate_day(ticket.getDate_day());
        ticket.setPlace(ticket.getPlace());
        ticket.setPrice(ticket.getPrice());
        ticketService.addTicket(ticket);
        return "redirect:/admin/tickets";
    }

    @GetMapping("/admin/tickets/delete/{id}")
    public String deleteTicket(@PathVariable int id){
        ticketService.removeTicketById(id);
        return "redirect:/admin/tickets";
    }
}
