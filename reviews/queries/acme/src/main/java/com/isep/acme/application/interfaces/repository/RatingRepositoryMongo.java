package com.isep.acme.application.interfaces.repository;

import com.isep.acme.model.Rating;
import com.isep.acme.model.Rating_Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface RatingRepositoryMongo extends MongoRepository<Rating_Mongo,Long> {

    @Query("{'rate':?0}")
    Optional<Rating> findByRate (Double rate);
    @Query("{'idRating':?0}")
    Optional<Rating> findByRatingId (Long rating);
}