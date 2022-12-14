package com.project.criterion.presentation;

import com.project.criterion.business.*;
import com.project.criterion.business.service.MovieDTO;
import com.project.criterion.business.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

@RestController
public class MovieApiController {
    @Autowired
    MovieService movieService;

    @PostMapping("/api/movie/new")
    public ResponseEntity<String> addMovie(@RequestBody Map<String, String> input) {

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

        } catch (InputMismatchException | NumberFormatException d) {
            return new ResponseEntity<>("incorrect parameters", HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/api/movie")
    public List<MovieDTO> getMovie(@RequestParam(value = "title") String title) {
        List<MovieDTO> movies = movieService.findByTitle(title);
        if (movies == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return movies;
        }
    }


    @GetMapping("/api/movie/search")
    public List<MovieDTO> getByFilter(@RequestParam(value = "genre", required = false) String genre, @RequestParam(value = "releaseYear", required = false) String releaseYear) {
        if (releaseYear != null && genre != null) {
            return movieService.findByGenreAndReleaseYear(genre, releaseYear);
        } else if (releaseYear == null) {
            return movieService.findByGenre(genre.toLowerCase());
        } else {
            return movieService.findByReleaseYear(releaseYear);
        }
    }

    @GetMapping("/api/movie/latest")
    public List<MovieDTO> findLatest() {
        return movieService.findLatest();
    }

    @GetMapping("/api/movie/{id}") //for test purposes
    public MovieDTO findMovie(@PathVariable Long id) {
        return movieService.findMoviesBymId(id);
    }

    @GetMapping("/api/genre")
    public List<Genre> getAllGenres() {
        return movieService.getAllGenres();
    }

    @GetMapping("/api/actor")
    public List<Actor> searchForActors(@RequestParam(value = "name") String name) {
        return movieService.getAllActors(name.toLowerCase());
    }

    @PostMapping("/api/actor")
    public ResponseEntity<String> postActor(@RequestBody Actor actor) {
        String actorId = movieService.saveActor(actor).toString();
        return new ResponseEntity<>("{\"id\": " + actorId + "}", HttpStatus.OK);
    }


}
