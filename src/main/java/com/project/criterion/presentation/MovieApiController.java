package com.project.criterion.presentation;

import com.project.criterion.business.Movie;
import com.project.criterion.business.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

public class MovieApiController {
    @Autowired
    MovieService movieService;

    @PostMapping("/api/movie/new")
    public ResponseEntity<String> addMovie(@Valid @RequestBody Movie movie) {
        Movie movie1 = movieService.save(movie);
        return new ResponseEntity<>("{\"id\": " + movie1.getMId() + "}", HttpStatus.OK);
    }

    @GetMapping("/api/movie/")
    public List<Movie> getMovie(@RequestParam(value = "title")String title) {
        if (movieService.findRecipeById(title) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return movieService.findRecipeById(title);
        }
    }


    //@PutMapping("/api/movie/{id}") hibernate already does update for existing ids
    @GetMapping("/api/movie/search/")
    public List<Movie> getByFilter(@RequestParam(value = "genre", required = false) String genre, @RequestParam(value = "releaseYear", required = false) String releaseYear) {
        if (genre == null && releaseYear == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else if (releaseYear == null) {
            return movieService.findByCategory(genre.toLowerCase());
        } else if (genre == null) {
            return movieService.findByName(releaseYear.toLowerCase());
        } else {
            return movieService.findByNameAndCategory(releaseYear, genre);
        }
    }

    @GetMapping("/api/movie/latest")
    public List<Movie> findLast() {
        return codesService.findLast();
    }

}
