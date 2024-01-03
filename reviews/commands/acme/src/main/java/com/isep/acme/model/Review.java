package com.isep.acme.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

public abstract class Review {

    public abstract Long getIdReview();

    public abstract String getApprovalStatus();

    public abstract Boolean setApprovalStatus(String approvalStatus);
    public abstract String getReviewText() ;

    public abstract void setReviewText(String reviewText);

    public abstract void setReport(String report);

    public abstract LocalDate getPublishingDate();

    public abstract void setPublishingDate(LocalDate publishingDate);


    public abstract void setCreationDate(LocalDate creationDate);


    public abstract String getFunFact();

    public abstract void setFunFact(String funFact);

    public abstract void setProduct(Product product);

    public abstract Product getProduct();

    public abstract User getUser();

    public abstract void setUser(User user);

    public abstract Rating getRating() ;

    public abstract void setRating(Rating rating);

    public abstract List<Vote> getUpVote();
    public abstract void setUpVote(List<Vote> upVote);
    public abstract List<Vote> getAcceptance();

    public abstract void setAcceptance(List<Vote> acceptance);

    public abstract List<Vote> getDownVote();

    public abstract void setDownVote(List<Vote> downVote);

    public abstract boolean addUpVote(Vote upVote);

    public abstract boolean addDownVote(Vote downVote);
}
