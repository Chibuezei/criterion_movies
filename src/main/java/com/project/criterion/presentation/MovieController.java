package com.project.criterion.presentation;

import com.project.criterion.business.Actor;
import com.project.criterion.business.service.MovieDTO;
import com.project.criterion.business.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping(value = "/movie/new", produces = MediaType.TEXT_HTML_VALUE)
    public String addMovie() {
        return "createnew";
    }

    @GetMapping("/movie")
    public String getMovie(@RequestParam(value = "title") String title, Model model) {
        List<MovieDTO> movies = movieService.findByTitle(title);
        if (movies == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            model.addAttribute("movieList", movies);
            return "searchResult";
        }
    }


    @GetMapping("/movie/search")
    public String getByFilter(@RequestParam(value = "genre", required = false) String genre, @RequestParam(value = "releaseYear", required = false) String releaseYear, Model model) {
        List<MovieDTO> movies;
        if (releaseYear != null && genre != null) {
            movies = movieService.findByGenreAndReleaseYear(genre, releaseYear);
        } else if (releaseYear == null) {
            movies = movieService.findByGenre(genre.toLowerCase());
        } else {
            movies = movieService.findByReleaseYear(releaseYear);
        }
        model.addAttribute("movieList", movies);
        return "searchResult";
    }


    @GetMapping("/movie/latest")
    public String findLatest(Model model) {
        model.addAttribute("movieList", movieService.findLatest());
        return "movieList";
    }

    @GetMapping("/genre")
    public String getAllGenres(Model model) {
        model.addAttribute("genreList", movieService.getAllGenres());
        return "Genre";
    }

    @GetMapping("/actor")
    public String searchForActors(@RequestParam(value = "name") String name, Model model) {
        List<Actor> actorList = movieService.getAllActors(name.toLowerCase());
        model.addAttribute("actorList", actorList);
        return "actorList";
    }

    @GetMapping(value = "/actor/new", produces = MediaType.TEXT_HTML_VALUE)
    public String postActor() {
        return "addActor";
    }
}
