package com.project.criterion.business.service;

import com.project.criterion.business.Cast;
import com.project.criterion.business.Internal;
import com.project.criterion.business.Movie;
import com.project.criterion.business.Rating;
import com.project.criterion.persistence.CastRepository;
import com.project.criterion.persistence.InternalRepository;
import com.project.criterion.persistence.MovieRepository;
import com.project.criterion.persistence.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CastRepository castRepository;

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    InternalRepository internalRepository;


    public Long save(Movie movie1, Cast cast, Rating rating, Integer harddrive) {
        Movie movie = movieRepository.save(movie1);
        cast.setMId(movie.getMId());
        castRepository.save(cast);
        rating.setMId(movie.getMId());
        ratingRepository.save(rating);
        Internal internal = new Internal(movie.getMId(), harddrive);
        internalRepository.save(internal);
        return movie.getMId();
    }

    public List<Movie> findLatest() {
        return movieRepository.findLatest();
    }

    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public Movie findMoviesBymId(Integer mId) {
        return movieRepository.findMovieBymId(mId);
    }

    public List<Movie> findByGenre(Integer genre) {
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> findByReleaseYear(String year) {
        return movieRepository.findByReleaseYear(year);
    }

}
