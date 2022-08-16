package com.project.criterion.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actor")
@NamedQuery(name = "Actor.findByNames", query = "select u from Actor u where lower(u.firstname) LIKE '%' || ?1 || '%' or lower(u.lastname) LIKE '%' || ?1 || '%' ")
public class Actor {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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

    public Actor(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
