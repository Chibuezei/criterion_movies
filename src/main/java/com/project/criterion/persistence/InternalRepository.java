package com.project.criterion.persistence;

import com.project.criterion.business.Internal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalRepository extends JpaRepository<Internal, Long> {

}
