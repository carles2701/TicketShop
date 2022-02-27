package com.carles2701.TicketShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Tickets {

    @Id
    private long id;
    @Column(nullable = false)
    private Artists artists;
    @Column(nullable = false)
    private String place;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private double price;

    public Tickets(){

    }

    public Tickets(Artists artists, String place, String date, double price) {
        this.artists = artists;
        this.place = place;
        this.date = date;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
