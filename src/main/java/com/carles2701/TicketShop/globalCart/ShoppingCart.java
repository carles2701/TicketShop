package com.carles2701.TicketShop.globalCart;

import com.carles2701.TicketShop.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public static List<Ticket> cart;
    static {
        cart = new ArrayList<Ticket>();
    }
}
