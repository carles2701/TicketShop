package com.carles2701.TicketShop.model;

import javax.persistence.*;

@Entity(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private int id;
    @Column(nullable = false)
    private String knownAs;
    @Column(nullable = false)
    private String genre;

    public Artist(){

    }

    public Artist(int id, String knownAs, String genre) {
        this.id = id;
        this.knownAs = knownAs;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKnownAs() {
        return knownAs;
    }

    public void setKnownAs(String knownAs) {
        this.knownAs = knownAs;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
