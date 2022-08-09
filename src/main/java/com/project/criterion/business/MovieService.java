package com.project.criterion.business;

import com.project.criterion.persistence.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;


    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
    public List<Movie> findLatest(){
        return movieRepository.findLatest();
    }

    public List<Movie> findByTitle(String title){
        return movieRepository.findByTitle(title);
    }

    public Movie findMoviesBymId(Integer mId){
        return movieRepository.findMovieBymId(mId);
    }
    public List<Movie> findByGenre(Integer genre){
        return movieRepository.findByGenre(genre);
    }
    public List<Movie> findByReleaseYear(String year){
        return movieRepository.findByReleaseYear(year);
    }

}
