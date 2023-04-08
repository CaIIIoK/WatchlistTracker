package com.orud.watchlisttracker.repository;

import com.orud.watchlisttracker.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
