package com.isep.acme.messageBroker;

import com.isep.acme.application.interfaces.service.ReviewService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "review_accepted")
public class ReviewMBListener {

    @Autowired
    ReviewService reviewService;

    @RabbitHandler
    public void reviewAccepted(Long reviewId){
        //System.out.println(reviewId);
        reviewService.acceptReview(reviewId);
    }
}
