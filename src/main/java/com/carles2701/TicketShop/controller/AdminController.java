package com.carles2701.TicketShop.controller;

import com.carles2701.TicketShop.model.Artist;
import com.carles2701.TicketShop.model.Ticket;
import com.carles2701.TicketShop.service.ArtistService;
import com.carles2701.TicketShop.service.TicketService;
import com.carles2701.TicketShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    ArtistService artistService;

    @Autowired
    TicketService ticketService;

    @Autowired
    UserService userService;

    public static String uploadDirection = System.getProperty("user.dir") + "/src/main/resources/static/images";

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

    @PostMapping(value = "/admin/artists/add")
    public String postArtistsAdd(@ModelAttribute("artist") Artist artist,
                                 @RequestParam("artistImage")MultipartFile multipartFile,
                                 @RequestParam("imgName")String photoName) throws IOException {
        String UID_Image;
        if(!multipartFile.isEmpty()){
            UID_Image = multipartFile.getOriginalFilename();
            Path file_name_path = Paths.get(uploadDirection, UID_Image);
            Files.write(file_name_path, multipartFile.getBytes());
        }
        else {
            UID_Image = photoName;
        }
        artist.setImageName(UID_Image);

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
        Optional<Artist> artist = artistService.getArtistById(id);
        if(artist.isPresent()) {
            model.addAttribute("artist", artist.get());
            return "artistAddPage";
        }
        else
            return "404";
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
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("artists", artistService.getAllArtists());
        return "ticketAddPage";
    }

    @PostMapping("/admin/tickets/add")
    public String postAddTicket(@ModelAttribute("ticket") Ticket ticket){
        ticketService.addTicket(ticket);
        return "redirect:/admin/tickets";
    }

    @GetMapping("/admin/tickets/update/{id}")
    public String updateTicket(@PathVariable int id, Model model){
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        if(ticket.isPresent()) {
            model.addAttribute("artists",artistService.getAllArtists());
            model.addAttribute("ticket",ticket);
            return "ticketAddPage";
        }
        else
            return "404";
    }


    /*
    @GetMapping("/admin/ticket/update/{id}")
    public String updateTicket(@PathVariable int id, Model model){
        Ticket ticket = ticketService.getTicketById(id).get();
        Ticket newTicket = new Ticket();
        newTicket.setId(ticket.getId());
        newTicket.setArtist(ticket.getArtist());
        newTicket.setDate_day(ticket.getDate_day());
        newTicket.setDate_month(ticket.getDate_month());
        newTicket.setPlace(ticket.getPlace());
        newTicket.setPrice(ticket.getPrice());
        newTicket.setDate_year(ticket.getDate_year());

        model.addAttribute("artist",artistService.getAllArtists());
        model.addAttribute("ticket",newTicket);

        return "ticketPage";
    }

     */

    @GetMapping("/admin/tickets/delete/{id}")
    public String deleteTicket(@PathVariable int id){
        ticketService.removeTicketById(id);
        return "redirect:/admin/tickets";
    }
}
