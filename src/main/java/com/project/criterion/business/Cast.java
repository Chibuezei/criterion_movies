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
@Table(name = "cast")
public class Cast {
    @Id
    private Integer m_id;
    private Integer actor1;
    private Integer actor2;
    private Integer actor3;

}
