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

    @Query(nativeQuery = true, value = "SELECT * FROM movie where m_id in (select m_id from cast where a_id in " +
            "(select a_id from actor where firstname LIKE '%' || ?1 || '%' or lastname LIKE '%' || ?1 || '%' ) ")
    List<Movie> findByActors(String name);

    List<Movie> findByTitle(String title);

    Movie findMovieBymId(Long mId);//i have forgotten why this is here,
    @Query(nativeQuery = true, value = "SELECT * FROM movie where genre in (select id from genre where name LIKE '%' || ?1 || '%' ) ")
    List<Movie> findByGenre(String genre);
    List<Movie> findByReleaseYear(String year);
    @Query(nativeQuery = true, value = "SELECT * FROM movie where release_year = ?2 and genre in (select id from genre where name LIKE '%' || ?1 || '%' ) ")
    List<Movie> findByGenreAndReleaseYear(String genre, String releaseYear);


}
