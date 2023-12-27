package com.isep.acme.application.interfaces.repository;

import com.isep.acme.model.Product;
import com.isep.acme.model.Product_Mongo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepositoryMongo extends MongoRepository<Product_Mongo,Long> {
    @Query("{'sku' : ?0}")
    Optional<Product> findBySku(String sku);

    @Query("{'designation' : ?0}")
    List<Product> findByDesignation(String designation);
}