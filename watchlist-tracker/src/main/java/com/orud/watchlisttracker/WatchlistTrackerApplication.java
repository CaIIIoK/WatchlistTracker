package com.orud.watchlisttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories
public class WatchlistTrackerApplication {
	public static void main(String[] args) {
		SpringApplication.run(WatchlistTrackerApplication.class, args);
	}
}
