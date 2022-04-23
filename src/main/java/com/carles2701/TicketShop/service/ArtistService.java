package com.carles2701.TicketShop.service;

import com.carles2701.TicketShop.entity.Artist;
import com.carles2701.TicketShop.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }
    public void addArtist(Artist artist){
        artistRepository.save(artist);
    }
    public Optional<Artist> getArtistById(int id){
        return artistRepository.findById((id));
    }
    public void removeArtistById(int id) {
        artistRepository.deleteById(id);
    }
}
