package com.orud.watchlisttracker.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tv_shows")
public class TVShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(nullable = false)
    private Integer releaseYear;

    @Column(name = "last_watch_date")
    private LocalDate lastWatchDate;

    @Column(nullable = false)
    private boolean isWatched;

    @OneToMany(mappedBy = "tvShow")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "tvShow")
    private List<WatchedTVShow> watchedTVShows = new ArrayList<>();

    @OneToMany(mappedBy = "tvShow")
    private List<PlannedTVShow> plannedTVShows = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "tv_show_category",
            joinColumns = @JoinColumn(name = "tv_show_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public LocalDate getLastWatchDate() {
        return lastWatchDate;
    }

    public void setLastWatchDate(LocalDate lastWatchDate) {
        this.lastWatchDate = lastWatchDate;
    }

    public Boolean getWatched() {
        return isWatched;
    }

    public void setWatched(Boolean watched) {
        isWatched = watched;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<WatchedTVShow> getWatchedTVShows() {
        return watchedTVShows;
    }

    public void setWatchedTVShows(List<WatchedTVShow> watchedTVShows) {
        this.watchedTVShows = watchedTVShows;
    }

    public List<PlannedTVShow> getPlannedTVShows() {
        return plannedTVShows;
    }

    public void setPlannedTVShows(List<PlannedTVShow> plannedTVShows) {
        this.plannedTVShows = plannedTVShows;
    }
}
