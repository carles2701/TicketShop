package com.carles2701.TicketShop.controller;

import com.carles2701.TicketShop.globalCart.ShoppingCart;
import com.carles2701.TicketShop.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShoppingCartController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/addToCart/{id}")
    public String addToShoppingCart(@PathVariable long id){
        ShoppingCart.shoppingCart.add(ticketService.getTicketById(id).get());
        return "redirect:/shop";
    }

}
