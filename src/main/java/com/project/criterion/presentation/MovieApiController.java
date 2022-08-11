package com.project.criterion.presentation;

import com.project.criterion.business.Cast;
import com.project.criterion.business.Movie;
import com.project.criterion.business.Rating;
import com.project.criterion.business.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class MovieApiController {
    @Autowired
    MovieService movieService;

    @PostMapping("/api/movie/new")
    public ResponseEntity<String> addMovie(@Valid Map<String, String> input) {

        try {
            String title = input.get("title");
            Integer genre = Integer.valueOf(input.get("genre"));
            boolean edited = Boolean.parseBoolean(input.get("edited"));
            String releaseYear = input.get("releaseYear");
            Integer duration = Integer.valueOf(input.get("duration"));
            String summary = input.get("summary");
            Integer actor1 = Integer.valueOf(input.get("actor1"));
            Integer actor2 = Integer.valueOf(input.get("actor2"));
            Integer actor3 = Integer.valueOf(input.get("actor3"));

            Integer hdd = Integer.valueOf(input.get("harddrive"));
            Integer imdb = Integer.valueOf(input.get("imdb"));
            Integer rottenTomatometer = Integer.valueOf(input.get("rottenTomatometer"));
            Integer rottenAudience = Integer.valueOf(input.get("rottenAudience"));
            Rating rating = new Rating(imdb, rottenTomatometer, rottenAudience);
            Movie movie = new Movie(title, genre, releaseYear, duration, edited, summary);
            Cast cast = new Cast(actor1, actor2, actor3);
            Long movieId = movieService.save(movie, cast, rating, hdd);
            return new ResponseEntity<>("{\"id\": " + movieId + "}", HttpStatus.OK);

        } catch (InputMismatchException e) {
            return new ResponseEntity<>("incorrect parameters", HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/api/movie/")
    public List<Movie> getMovie(@RequestParam(value = "title") String title) {
        if (movieService.findByTitle(title) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return movieService.findByTitle(title);
        }
    }


    //@PutMapping("/api/movie/{id}") hibernate already does update for existing ids
    @GetMapping("/api/movie/search/")
    public List<Movie> getByFilter(@RequestParam(value = "genre", required = false) int genre, @RequestParam(value = "releaseYear", required = false) String releaseYear) {
        if (releaseYear == null) {
            return movieService.findByGenre(genre);
        } else {
            return movieService.findByReleaseYear(releaseYear.toLowerCase());
        }
    }

    @GetMapping("/api/movie/latest")
    public List<Movie> findLatest() {
        return movieService.findLatest();
    }

}
