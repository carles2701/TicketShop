package com.carles2701.TicketShop.service;

import com.carles2701.TicketShop.model.Artists;
import com.carles2701.TicketShop.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    public List<Artists> getAllArtists() {
        return artistRepository.findAll();
    }
    public void addArtist(Artists artist){
        artistRepository.save(artist);
    }
    public Optional<Artists> getArtistById(long id){
        return artistRepository.findById((id));
    }
    public void removeArtistById(long id) {
        artistRepository.deleteById(id);
    }
}
