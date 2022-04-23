package com.carles2701.TicketShop.entityDTO;

public class TicketDTO {
    private int id;
    private int artistId;
    private String place;
    private String date_year;
    private String date_month;
    private String date_day;
    private double price;

    public TicketDTO(int id, int artistId, String place, String date_year, String date_month, String date_day, double price) {
        this.id = id;
        this.artistId = artistId;
        this.place = place;
        this.date_year = date_year;
        this.date_month = date_month;
        this.date_day = date_day;
        this.price = price;
    }

    public TicketDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
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

    @Override
    public String toString() {
        return "TicketDTO{" +
                "id=" + id +
                ", artistId=" + artistId +
                ", place='" + place + '\'' +
                ", date_year='" + date_year + '\'' +
                ", date_month='" + date_month + '\'' +
                ", date_day='" + date_day + '\'' +
                ", price=" + price +
                '}';
    }
}
