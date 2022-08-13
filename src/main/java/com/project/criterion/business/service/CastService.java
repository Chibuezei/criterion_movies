package com.project.criterion.business.service;

import com.project.criterion.business.Cast;
import com.project.criterion.persistence.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CastService {

    @Autowired
    CastRepository castRepository;

    public Cast findMovieCast(Long mId){
        return castRepository.findByMid(mId);
    }

}
