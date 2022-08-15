package com.project.criterion.business.service;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.criterion.business.Actor;
import com.project.criterion.business.Movie;
import com.project.criterion.business.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    @JsonIgnore
    private Long mId;
    private String title;
    private String genre;
    private String releaseYear;
    private List<Actor> cast;
    private Optional<Rating> rating;
    private String duration;
    private Boolean edited;
    private String summary;

    public MovieDTO(Movie movie) {
        this.mId = movie.getMId();
        this.title = movie.getTitle();
        this.releaseYear = movie.getReleaseYear();
        this.duration = timeConverter(movie.getDuration());
        this.edited = movie.getEdited();
        this.summary = movie.getSummary();
    }

    private String timeConverter(Integer mins) {
        if (mins == null) {
            return null; //this conditional was added because there are some movies without duration
        } else {
            Integer hours = mins / 60;
            Integer minutes = mins % 60;
            return String.format("%d hours:%02d minutes", hours, minutes);
        }
    }
}
