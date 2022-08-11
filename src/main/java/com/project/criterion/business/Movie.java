package com.project.criterion.business;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie")
@NamedQuery(name = "Movie.findByTitle", query = "select u from Movie u where lower(u.title) LIKE '%' || ?1 || '%' order by u.releaseYear desc")
public class Movie {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mId;
    private String title;
    private Integer genre;
    private String releaseYear;
    @Column(name = "duration_mins")
    private Integer duration;
    private boolean edited;
    private String summary;


    public Movie(String title, Integer genre, String releaseYear, Integer duration, boolean edited, String summary) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.edited = edited;
        this.summary = summary;
    }
}
