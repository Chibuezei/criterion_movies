package com.project.criterion.business;

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
@Table(name = "internal")
public class Internal {
    @Id
    private Integer id;
    private Integer movieId;
    private Integer HDD;
}
