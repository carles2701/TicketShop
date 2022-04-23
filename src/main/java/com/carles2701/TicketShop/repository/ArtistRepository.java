package com.carles2701.TicketShop.repository;

import com.carles2701.TicketShop.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}
