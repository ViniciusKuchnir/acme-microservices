package com.isep.acme.application.mapper;

import com.isep.acme.application.dto.ReviewDTO;
import com.isep.acme.model.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewMapper {

    public static ReviewDTO toDto(Review review){
        return new ReviewDTO(review.getIdReview(), review.getReviewText(), review.getPublishingDate(), review.getApprovalStatus(), review.getFunFact(), review.getRating().getRate(), review.getUpVote().size());
    }

    public static List<ReviewDTO> toDtoList(List<Review> review) {
        List<ReviewDTO> dtoList = new ArrayList<>();

        for (Review rev: review) {
            dtoList.add(toDto(rev));
        }
        return dtoList;
    }
}