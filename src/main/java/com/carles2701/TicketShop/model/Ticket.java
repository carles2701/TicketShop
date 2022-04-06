package com.carles2701.TicketShop.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;
    @Column(nullable = false)
    private String place;
    @Column(nullable = false)
    private String date_year;
    @Column(nullable = false)
    private String date_month;
    @Column(nullable = false)
    private String date_day;
    @Column(nullable = false)
    private double price;

    public Ticket(){

    }

    public Ticket(int id, Artist artist, String place, String date_year, String date_month, String date_day, double price) {
        this.id = id;
        this.artist = artist;
        this.place = place;
        this.date_year = date_year;
        this.date_month = date_month;
        this.date_day = date_day;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate_year() {
        return date_year;
    }

    public void setDate_year(String date_year) {
        this.date_year = date_year;
    }

    public String getDate_month() {
        return date_month;
    }

    public void setDate_month(String date_month) {
        this.date_month = date_month;
    }

    public String getDate_day() {
        return date_day;
    }

    public void setDate_day(String date_day) {
        this.date_day = date_day;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
