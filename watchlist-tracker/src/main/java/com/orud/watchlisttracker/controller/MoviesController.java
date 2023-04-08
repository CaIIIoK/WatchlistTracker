package com.orud.watchlisttracker.controller;

import com.orud.watchlisttracker.domain.Movie;
import com.orud.watchlisttracker.repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final MovieRepository movieRepository;

    public MoviesController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createMovie(@RequestBody Movie movie) throws URISyntaxException {
        Movie savedShow = movieRepository.save(movie);
        return ResponseEntity.created(new URI("/movies/" + savedShow.getId())).body(savedShow);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Movie currentMovie = movieRepository.findById(id).orElseThrow(RuntimeException::new);
        currentMovie.setTitle(movie.getTitle());
        currentMovie = movieRepository.save(movie);

        return ResponseEntity.ok(currentMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}