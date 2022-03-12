package com.carles2701.TicketShop.globalCart;

import com.carles2701.TicketShop.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public static List<Ticket> shoppingCart;
    static {
        shoppingCart = new ArrayList<Ticket>();
    }
}
