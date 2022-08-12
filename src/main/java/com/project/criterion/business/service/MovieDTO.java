package com.project.criterion.business.service;


import com.project.criterion.business.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Long mId;
    private String title;
    private Integer genre;
    private String releaseYear;
    private List<String> cast;
    private List<Integer> rating;
    private String duration;
    private Boolean edited;
    private String summary;

    public MovieDTO(Movie movie) {
        this.mId = movie.getMId();
        this.title = movie.getTitle();
        this.genre = movie.getGenre();
        this.releaseYear = movie.getReleaseYear();
        this.duration = timeConverter(movie.getDuration());
        this.edited = movie.getEdited();
        this.summary = movie.getSummary();
    }

    private String timeConverter(Integer mins) {
        int hours = mins / 60;
        int minutes = mins % 60;
        return String.format("%d hours:%02d minutes", hours, minutes);
    }
}
