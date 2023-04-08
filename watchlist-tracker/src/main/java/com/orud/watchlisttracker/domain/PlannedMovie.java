package com.orud.watchlisttracker.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "planned_movies")
public class PlannedMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate datePlanned;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDatePlanned() {
        return datePlanned;
    }

    public void setDatePlanned(LocalDate datePlanned) {
        this.datePlanned = datePlanned;
    }
}
