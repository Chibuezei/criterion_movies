package com.project.criterion.presentation;

import com.project.criterion.business.service.MovieDTO;
import com.project.criterion.business.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/movie/latest")
    public String findLatest(Model model) {
        model.addAttribute("movieList", movieService.findLatest());
        return "movieList";
    }

    @GetMapping("/movie")
    public List<MovieDTO> getMovie(@RequestParam(value = "title") String title) {
        List<MovieDTO> movies = movieService.findByTitle(title);
        if (movies == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return movies;
        }
    }
}