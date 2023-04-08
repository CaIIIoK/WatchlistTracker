package com.orud.watchlisttracker.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "planned_tv_shows")
public class PlannedTVShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tv_show_id", nullable = false)
    private TVShow tvShow;

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

    public TVShow getTvShow() {
        return tvShow;
    }

    public void setTvShow(TVShow tvShow) {
        this.tvShow = tvShow;
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
