package com.orud.watchlisttracker.controller;

import com.orud.watchlisttracker.domain.TVShow;
import com.orud.watchlisttracker.repository.TVShowRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/tvshows")
public class TVShowsController {
    private final TVShowRepository tvShowRepository;

    public TVShowsController(TVShowRepository tvShowRepository) {
        this.tvShowRepository = tvShowRepository;
    }

    @GetMapping
    public List<TVShow> getClients() {
        return tvShowRepository.findAll();
    }

    @GetMapping("/{id}")
    public TVShow getShow(@PathVariable Long id) {
        return tvShowRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createShow(@RequestBody TVShow show) throws URISyntaxException {
        TVShow savedShow = tvShowRepository.save(show);
        return ResponseEntity.created(new URI("/tvshows/" + savedShow.getId())).body(savedShow);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateShow(@PathVariable Long id, @RequestBody TVShow show) {
        TVShow currentShow = tvShowRepository.findById(id).orElseThrow(RuntimeException::new);
        currentShow.setTitle(show.getTitle());
        currentShow.setDescription(show.getDescription());
        currentShow = tvShowRepository.save(show);

        return ResponseEntity.ok(currentShow);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteShow(@PathVariable Long id) {
        tvShowRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
