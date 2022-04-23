package com.carles2701.TicketShop.controller;

import com.carles2701.TicketShop.globalCart.ShoppingCart;
import com.carles2701.TicketShop.entity.Ticket;
import com.carles2701.TicketShop.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShoppingCartController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/addToCart/{id}")
    public String addToShoppingCart(@PathVariable int id){
        ShoppingCart.shoppingCart.add(ticketService.getTicketById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String getShopCart(Model model){
        model.addAttribute("size_shopping_cart", ShoppingCart.shoppingCart.size());
        model.addAttribute("all_elements_of_cart", ShoppingCart.shoppingCart.stream().mapToDouble(Ticket::getPrice).sum());
        model.addAttribute("cart", ShoppingCart.shoppingCart);
        return "shoppingCartPage";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String ShopCartItemRemove(@PathVariable int index){
        ShoppingCart.shoppingCart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/summary")
    public String summary(Model model){
        model.addAttribute("all_elements_of_cart", ShoppingCart.shoppingCart.stream().mapToDouble(Ticket::getPrice).sum());
        return "summaryPage";
    }
}
