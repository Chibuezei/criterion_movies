package com.project.criterion.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cast")
public class Cast {
    @Id
    @JsonIgnore
    private Long mId;

    @Column(name = "actor1")
    private Integer actor1;

    @Column(name = "actor2")
    private Integer actor2;

    @Column(name = "actor3")
    private Integer actor3;

    public Cast(Integer actor1, Integer actor2, Integer actor3) {
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.actor3 = actor3;
    }
}
