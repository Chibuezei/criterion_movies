package com.project.criterion.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @JsonIgnore
    private Long mId;
    private Integer imdb;
    private Integer rottenTomatometer;
    private Integer rottenAudience;

    public Rating(Integer imdb, Integer rottenTomatometer, Integer rottenAudience) {
        this.imdb = imdb;
        this.rottenTomatometer = rottenTomatometer;
        this.rottenAudience = rottenAudience;
    }
}
