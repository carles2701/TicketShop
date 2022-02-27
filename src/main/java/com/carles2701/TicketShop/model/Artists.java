package com.carles2701.TicketShop.model;

import javax.persistence.*;

@Entity
@Table
public class Artists {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "artist_id")
    private long id;
    @Column(nullable = false)
    private String knownAs;
    @Column(nullable = false)
    private String genre;

    public Artists(){

    }

    public Artists(String knownAs, String genre) {
        this.knownAs = knownAs;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

