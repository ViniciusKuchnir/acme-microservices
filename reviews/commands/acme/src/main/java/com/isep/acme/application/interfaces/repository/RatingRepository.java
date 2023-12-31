package com.isep.acme.application.interfaces.repository;

import com.isep.acme.model.Rating_SQL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.isep.acme.model.Rating;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingRepository extends CrudRepository<Rating_SQL, Long> {

    @Query("SELECT r FROM Rating_SQL r WHERE r.rate=:rate")
    Optional<Rating> findByRate(Double rate);

}
