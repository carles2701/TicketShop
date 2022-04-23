package com.carles2701.TicketShop.controller;

import com.carles2701.TicketShop.globalCart.ShoppingCart;
import com.carles2701.TicketShop.service.ArtistService;
import com.carles2701.TicketShop.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomePageController {

    @Autowired
    ArtistService artistService;

    @Autowired
    TicketService ticketService;

    @GetMapping({"/","/home","/index"})
    public String homePage(Model model){
        model.addAttribute("shoppingCart", ShoppingCart.shoppingCart.size());
        return "index";
    }

    @GetMapping("/shop/artist/{id}")
    public String shopByArtist(Model model, @PathVariable int id){
        model.addAttribute("ticketsByArtists",ticketService.getAllTicketsByArtistId(id));
        model.addAttribute("shoppingCart", ShoppingCart.shoppingCart.size());
        model.addAttribute("artists", artistService.getAllArtists());
        return "shopPage";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("shoppingCart",ShoppingCart.shoppingCart.size());
        model.addAttribute("artists",artistService.getAllArtists());
        model.addAttribute("tickets",ticketService.getAllTickets());
        return "shopPage";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("ticket", ticketService.getTicketById(id).get());
        model.addAttribute("shoppingCart", ShoppingCart.shoppingCart.size());
        return "viewProductPage";
    }
}
