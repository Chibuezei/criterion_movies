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
import org.springframework.transaction.annotation.Transactional;

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

    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    @Transactional
    public Long save(Movie movie1, Cast cast, Rating rating, Integer harddrive) {
        System.out.println("before save");
        Movie movie = movieRepository.save(movie1);
        cast.setMId(movie.getMId());
        castRepository.save(cast);
        rating.setMId(movie.getMId());
        ratingRepository.save(rating);
        Internal internal = new Internal(movie.getMId(), harddrive);
        internalRepository.save(internal);
        System.out.println("after save");

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

    public List<Movie> findByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> findByReleaseYear(String year) {
        return movieRepository.findByReleaseYear(year);
    }

    public List<Movie> findByGenreAndReleaseYear(String genre, String releaseYear) {
        return movieRepository.findByGenreAndReleaseYear(genre, releaseYear);
    }

    /**
     * This method is used to get the movie cast and rating from their
     * respective repositories.
     */
    private List<MovieDTO> getMovieProperties(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();

        return null;
    }
}
