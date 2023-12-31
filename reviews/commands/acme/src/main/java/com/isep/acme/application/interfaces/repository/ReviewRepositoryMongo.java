package com.isep.acme.application.interfaces.repository;

import com.isep.acme.model.Review;
import com.isep.acme.model.Review_Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ReviewRepositoryMongo extends MongoRepository<Review_Mongo,Long> {

    @Query("{'productId' : ?0}")
    Optional<List<Review>> findByProductId(Long productId);

    @Query("{'approvalStatus'=pending}")
    Optional<List<Review>> findPendingReviews();

    @Query("{'approvalStatus'=active}")
    Optional<List<Review>> findActiveReviews();

    @Query("{'productId' : ?0 , 'approvalStatus' : ?1}")
    Optional<List<Review>> findByProductIdStatus(Long productId, String status);

    @Query("{'userId':?0}")
    Optional<List<Review>> findByUserId(Long userId);

    @Query("{'idReview':?0}")
    Optional<Review> findByReviewId(Long reviewId);

    @Query("{'upVote.userID': ?0}}")
    Optional<List<Review>> findUpVotedReviews(Long userId);

    @Query("{'downVote.userID': ?0}}")
    Optional<List<Review>> findDownVotedReviews(Long userId);
}