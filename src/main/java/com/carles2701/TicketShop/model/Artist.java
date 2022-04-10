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
    @Column(nullable = false)
    private String imageName;

    public Artist(){

    }

    public Artist(int id, String knownAs, String genre, String imageName) {
        this.id = id;
        this.knownAs = knownAs;
        this.genre = genre;
        this.imageName = imageName;
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", knownAs='" + knownAs + '\'' +
                ", genre='" + genre + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}
