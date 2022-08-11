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
@Table(name = "actor")
public class Actor {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer a_id;
    private String firstname;
    private String lastname;
    @Column(name = "othername")
    private String otherName;

    public Actor(String firstname, String lastname, String otherName) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.otherName = otherName;
    }
}
