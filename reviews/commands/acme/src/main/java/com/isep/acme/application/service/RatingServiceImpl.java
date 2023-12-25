package com.isep.acme.application.service;

import com.isep.acme.application.interfaces.repository.RatingRepositoryMongo;
import com.isep.acme.application.interfaces.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.isep.acme.model.Rating;
import com.isep.acme.application.interfaces.repository.RatingRepository;

import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository repository;

    @Autowired
    RatingRepositoryMongo repositoryMongo;

    @Value("${dataSource}")
    private String dataSource;

    public Optional<Rating> findByRate(Double rate){
        if(dataSource.equalsIgnoreCase("mongodb")){
            return repositoryMongo.findByRate(rate);
        } else {
            return repository.findByRate(rate);
        }
    }

}
