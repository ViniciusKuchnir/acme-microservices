package com.isep.acme.application.interfaces.repository;

import com.isep.acme.model.Review_SQL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.isep.acme.model.Product;
import com.isep.acme.model.Review;
import com.isep.acme.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends CrudRepository<Review_SQL, Long> {

    //Optional<Review> findById(Long productId);

    @Query("SELECT r FROM Review_SQL r WHERE r.product=:product ORDER BY r.publishingDate DESC")
    Optional<List<Review>> findByProductId(Product product);


    @Query("SELECT r FROM Review_SQL r WHERE r.approvalStatus='pending'")
    Optional<List<Review>> findPendingReviews();

    @Query("SELECT r FROM Review_SQL r WHERE r.approvalStatus='active'")
    Optional<List<Review>> findActiveReviews();

    @Query("SELECT r FROM Review_SQL r WHERE r.product=:product AND r.approvalStatus=:status ORDER BY r.publishingDate DESC")
    Optional<List<Review>> findByProductIdStatus(Product product, String status);

    @Query("SELECT r FROM Review_SQL r WHERE r.user=:user ORDER BY r.publishingDate DESC")
    Optional<List<Review>> findByUserId(User user);
}
