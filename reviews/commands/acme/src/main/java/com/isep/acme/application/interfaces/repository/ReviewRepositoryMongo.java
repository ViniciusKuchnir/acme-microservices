package com.isep.acme.application.interfaces.repository;

import com.isep.acme.model.Review;
import com.isep.acme.model.Review_Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ReviewRepositoryMongo extends MongoRepository<Review_Mongo,Long> {

    @Query("{'_productId' : ?0}")
    Optional<List<Review>> findByProductId(Long productId);

    @Query("{'_approvalStatus':'pending'}")
    Optional<List<Review>> findPendingReviews();

    @Query("{'_approvalStatus':'active'}")
    Optional<List<Review>> findActiveReviews();

    @Query("{'_productId' : ?0 , '_approvalStatus' : ?1}")
    Optional<List<Review>> findByProductIdStatus(Long productId, String status);

    @Query("{'_userId':?0}")
    Optional<List<Review>> findByUserId(Long userId);

    @Query("{'_idReview':?0}")
    Optional<Review_Mongo> findByReviewId(Long reviewId);

    @Query("{'_upVote.userID': ?0}}")
    Optional<List<Review>> findUpVotedReviews(Long userId);

    @Query("{'_downVote.userID': ?0}}")
    Optional<List<Review>> findDownVotedReviews(Long userId);
}