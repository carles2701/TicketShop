package com.carles2701.TicketShop;

import com.carles2701.TicketShop.model.Artist;
import com.carles2701.TicketShop.repository.ArtistRepository;
import com.carles2701.TicketShop.service.ArtistService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketShopApplication.class, args);

	}

}
