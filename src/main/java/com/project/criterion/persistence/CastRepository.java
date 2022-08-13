package com.project.criterion.persistence;

import com.project.criterion.business.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepository extends JpaRepository<Cast, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM cast where m_id = ?1")
    Cast findByMid(Long mId);
}
