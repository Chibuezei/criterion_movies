package com.project.criterion.persistence;

import com.project.criterion.business.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM genre where id = ?1")
    Genre findByGid(Integer aId);
}
