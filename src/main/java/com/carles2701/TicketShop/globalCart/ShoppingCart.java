package com.carles2701.TicketShop.globalCart;

import com.carles2701.TicketShop.entity.Artist;
import com.carles2701.TicketShop.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public Ticket ticket;
    public Artist artist;
    public static List<Ticket> cart;
    static {
        cart = new ArrayList<Ticket>();
    }

    public ShoppingCart() {
    }

    public ShoppingCart(Ticket ticket, Artist artist) {
        this.ticket = ticket;
        this.artist = artist;
    }

    public static void getCart(Artist artist) {
        artist.getKnownAs();
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Artist getArtist() {
        return artist;
    }
    public String artistGetKnownAs(){
        return artist.getKnownAs();
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public static List<Ticket> getCart() {
        return cart;
    }

    public static void setCart(List<Ticket> cart) {
        ShoppingCart.cart = cart;
    }
}
