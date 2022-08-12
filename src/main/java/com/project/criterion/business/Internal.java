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
@Table(name = "internal")
public class Internal {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "m_id")
    private Long movieId;
    private Integer HDD;

    public Internal(Long movieId, Integer HDD) {
        this.movieId = movieId;
        this.HDD = HDD;
    }
}
