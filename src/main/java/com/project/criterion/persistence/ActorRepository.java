package com.project.criterion.persistence;

import com.project.criterion.business.Actor;
import com.project.criterion.business.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM actor where a_id = ?1")
    Actor findByAid(Integer aId);

    @Query(nativeQuery = true, value = "select * from actor where firstname LIKE '%' || ?1 || '%' or lastname LIKE '%' || ?1 || '%' ")
    List<Actor> SearchByName(String name);//for some reasons which i will find out later, jpa was running the wrong query using this method

    List<Actor> findByNames(String name);
}
