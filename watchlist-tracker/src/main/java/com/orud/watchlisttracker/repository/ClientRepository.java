package com.orud.watchlisttracker.repository;

import com.orud.watchlisttracker.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}