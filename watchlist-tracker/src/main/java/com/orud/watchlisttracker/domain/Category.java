package com.orud.watchlisttracker.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Movie> movies;

    @ManyToMany(mappedBy = "categories")
    private Set<TVShow> tvShows;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Set<TVShow> getTvShows() {
        return tvShows;
    }

    public void setTvShows(Set<TVShow> tvShows) {
        this.tvShows = tvShows;
    }
}
