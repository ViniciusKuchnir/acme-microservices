package com.isep.acme.application.interfaces.repository;

import com.isep.acme.model.User;
import com.isep.acme.model.User_Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepositoryMongo extends MongoRepository<User_Mongo,Long> {

    @Query("{'username' : ?0}")
    Optional<User> findByUsername(String username);

    @Query("{'userId' : ?0}")
    User getById(Long userId);

    @Query("{'userId' : ?0}")
    Optional<User_Mongo> findById(Long userId);

}
