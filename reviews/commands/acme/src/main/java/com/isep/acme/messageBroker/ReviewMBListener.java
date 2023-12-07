package com.isep.acme.messageBroker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReviewMBListener {
    
    @RabbitListener(queues = "reviews.v1.review-accepted")
    public void reviewAccepted(String event){
        System.out.println(event);
    }
}
