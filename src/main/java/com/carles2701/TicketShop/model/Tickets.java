package com.carles2701.TicketShop.model;

import javax.persistence.*;

@Entity
@Table
public class Tickets {

    @Id
    @Column(name = "ticket_id")
    private long id;
    @Column(nullable = false)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id",referencedColumnName = "artist_id")
    private Artists artists;
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

    public Tickets(){

    }

    public Tickets(long id, Artists artists, String place, String date_year, String date_month, String date_day, double price) {
        this.id = id;
        this.artists = artists;
        this.place = place;
        this.date_year = date_year;
        this.date_month = date_month;
        this.date_day = date_day;
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
