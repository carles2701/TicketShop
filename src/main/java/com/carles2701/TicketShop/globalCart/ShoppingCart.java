package com.carles2701.TicketShop.globalCart;

import com.carles2701.TicketShop.model.Tickets;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public static List<Tickets> shoppingCart;
    static {
        shoppingCart = new ArrayList<Tickets>();
    }
}
