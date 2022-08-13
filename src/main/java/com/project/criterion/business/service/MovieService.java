package com.project.criterion.business.service;

import com.project.criterion.business.*;
import com.project.criterion.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    ActorRepository actorRepository;
    @Autowired
    InternalRepository internalRepository;

    @Autowired
    GenreRepository genreRepository;

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

    public MovieDTO findMoviesBymId(Long mId) {
        return getMovieProperties(movieRepository.findMovieBymId(mId));
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
    private MovieDTO getMovieProperties(Movie movie) {
        MovieDTO movieDTO = new MovieDTO(movie);
        movieDTO.setGenre(genreRepository.findByGid(movie.getGenre()).getName());
        movieDTO.setCast(findActors(castRepository.findByMid(movie.getMId())));
        System.out.println("here");
        movieDTO.setRating(90);

        return movieDTO;
    }

    /**
     * method to query the actors database to get actor details with their id
     * @param cast
     * @return List of Actors
     */
    private List<Actor> findActors(Cast cast) {
        List<Actor> actorList = new ArrayList<>();
        actorList.add(actorRepository.findByAid(cast.getActor1()));
        actorList.add(actorRepository.findByAid(cast.getActor2()));
        actorList.add(actorRepository.findByAid(cast.getActor2()));
        return actorList;
    }
}
