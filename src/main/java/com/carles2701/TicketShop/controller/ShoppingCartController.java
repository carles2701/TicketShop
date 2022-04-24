package com.carles2701.TicketShop.controller;

import com.carles2701.TicketShop.entity.Artist;
import com.carles2701.TicketShop.entityDTO.TicketDTO;
import com.carles2701.TicketShop.globalCart.ShoppingCart;
import com.carles2701.TicketShop.entity.Ticket;
import com.carles2701.TicketShop.service.ArtistService;
import com.carles2701.TicketShop.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShoppingCartController {
    @Autowired
    TicketService ticketService;

    @Autowired
    ArtistService artistService;

    @GetMapping("/addToCart/{id}")
    public String addToShoppingCart(@PathVariable int id,
                                    Model model){
        ShoppingCart.cart.add(ticketService.getTicketById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String getShopCart(Model model,
                              @ModelAttribute("artist")Artist artist){
        model.addAttribute("size_shopping_cart", ShoppingCart.cart.size());
        model.addAttribute("all_elements_of_cart", ShoppingCart.cart.stream().mapToDouble(Ticket::getPrice).sum());
        model.addAttribute("cart", ShoppingCart.cart);
        return "shoppingCartPage";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String ShopCartItemRemove(@PathVariable int index){
        ShoppingCart.cart.remove(index);
        return "redirect:/cart";

    }

    @GetMapping("/summary")
    public String summary(Model model){
        model.addAttribute("all_elements_of_cart", ShoppingCart.cart.stream().mapToDouble(Ticket::getPrice).sum());
        return "summaryPage";
    }
}
