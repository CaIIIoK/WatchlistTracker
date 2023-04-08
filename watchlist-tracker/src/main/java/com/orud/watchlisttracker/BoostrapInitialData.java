package com.orud.watchlisttracker;

import com.orud.watchlisttracker.repository.ClientRepository;
import com.orud.watchlisttracker.repository.MovieRepository;
import com.orud.watchlisttracker.repository.TVShowRepository;
import com.orud.watchlisttracker.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BoostrapInitialData implements CommandLineRunner {
    private final ClientRepository clientRepository;
    private final TVShowRepository tvShowRepository;
    private final MovieRepository movieRepository;
//    private final UserRepository userRepository;

    public BoostrapInitialData(ClientRepository clientRepository, TVShowRepository tvShowRepository,
                               MovieRepository movieRepository) {
        this.clientRepository = clientRepository;
        this.tvShowRepository = tvShowRepository;
        this.movieRepository = movieRepository;
//        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

    }
}