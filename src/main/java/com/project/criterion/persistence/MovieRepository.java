package com.project.criterion.persistence;

import com.project.criterion.business.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository  extends JpaRepository<Movie, Integer> {
//    @Query(nativeQuery = true, value = "SELECT * FROM movie order by m_id desc")
    @Query(nativeQuery = true, value = "SELECT * FROM movie order by m_id desc limit 20")
    List<Movie> findLatest();

    List<Movie> findByTitle(String title);

    Movie findMovieBymId(Integer mId);
    List<Movie> findByGenre(Integer genre);
    List<Movie> findByReleaseYear(String year);


}
