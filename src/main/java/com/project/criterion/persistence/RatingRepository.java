package com.project.criterion.persistence;

import com.project.criterion.business.Actor;
import com.project.criterion.business.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

}
