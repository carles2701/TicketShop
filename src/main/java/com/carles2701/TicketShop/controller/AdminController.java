package com.carles2701.TicketShop.controller;

import com.carles2701.TicketShop.entity.Artist;
import com.carles2701.TicketShop.entity.Ticket;
import com.carles2701.TicketShop.entityDTO.TicketDTO;
import com.carles2701.TicketShop.service.ArtistService;
import com.carles2701.TicketShop.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
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

    @GetMapping("/admin/tickets")
    public String getTickets(Model model){
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "ticketPage";
    }

    @GetMapping("/admin/tickets/add")
    public String getAddTicket(Model model){
        model.addAttribute("ticketDTO", new TicketDTO());
        model.addAttribute("artists", artistService.getAllArtists());
        return "ticketAddPage";
    }

    @PostMapping("/admin/tickets/add")
    public String postAddTicket(@ModelAttribute("ticketDTO") TicketDTO ticketDTO,
                                Model model){
        Ticket ticket = new Ticket();
        ticket.setId(ticketDTO.getId());
        ticket.setArtist(artistService.getArtistById(ticketDTO.getArtistId()).get());
        ticket.setPlace(ticketDTO.getPlace());
        ticket.setDate_year(ticketDTO.getDate_year());
        ticket.setDate_month(ticketDTO.getDate_month());
        ticket.setDate_day(ticketDTO.getDate_day());
        ticket.setPrice(ticketDTO.getPrice());
        ticketService.addTicket(ticket);
        return "redirect:/admin/tickets";
    }

    @GetMapping("/admin/tickets/update/{id}")
    public String updateTicket(@PathVariable int id, Model model) {
        Ticket ticket = ticketService.getTicketById(id).get();
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(ticketDTO.getId());
        ticketDTO.setArtistId(ticket.getArtist().getId());
        ticketDTO.setPlace(ticket.getPlace());
        ticketDTO.setDate_year(ticket.getDate_year());
        ticketDTO.setDate_month(ticket.getDate_month());
        ticketDTO.setDate_day(ticket.getDate_day());
        ticketDTO.setPrice(ticket.getPrice());
        ticketService.addTicket(ticket);

        model.addAttribute("artists", artistService.getAllArtists());
        model.addAttribute("ticketDTO", ticketDTO);

        return "ticketAddPage";
    }

    @GetMapping("/admin/tickets/delete/{id}")
    public String deleteTicket(@PathVariable int id){
        ticketService.removeTicketById(id);
        return "redirect:/admin/tickets";
    }
}
