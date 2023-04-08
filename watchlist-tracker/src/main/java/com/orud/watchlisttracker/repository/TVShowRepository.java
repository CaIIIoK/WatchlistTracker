package com.orud.watchlisttracker.repository;

import com.orud.watchlisttracker.domain.TVShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TVShowRepository extends JpaRepository<TVShow, Long> {
}
