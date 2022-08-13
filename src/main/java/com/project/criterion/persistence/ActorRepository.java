package com.project.criterion.persistence;

import com.project.criterion.business.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM actor where a_id = ?1")
    Actor findByAid(Integer aId);
}
