package com.isep.acme.application.interfaces.service;

import java.util.List;

import com.isep.acme.application.dto.CreateReviewDTO;
import com.isep.acme.application.dto.ReviewDTO;
import com.isep.acme.application.dto.VoteReviewDTO;
import com.isep.acme.model.*;

public interface ReviewService {

    Iterable<Review> getAll();

    List<ReviewDTO> getReviewsOfProduct(String sku, String status);

    List<ReviewDTO> findPendingReview();

    List<ReviewDTO> findReviewsByUser(Long userID);

    List<ReviewDTO> getGetTopReviews();
}
