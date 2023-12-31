package com.isep.acme.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Document(collection = "review")
public class Review_Mongo extends Review{

    @Id
    private String id;
    @Indexed(unique = true)
    private Long _idReview;
    private long _version;
    private String _approvalStatus;
    private String _reviewText;
    private List<Vote> _upVote;
    private List<Vote> _downVote;
    private List<Vote> _acceptance;
    private String _report;
    private LocalDate _publishingDate;
    private String _funFact;
    private Product_Mongo _product;
    private User_Mongo _user;
    private Rating_Mongo _rating;

    protected Review_Mongo(){}
    public Review_Mongo(final Long idReview, final long version, final String approvalStatus, final String reviewText, final LocalDate publishingDate, final String funFact) {
        this._idReview = Objects.requireNonNull(idReview);
        this._version = Objects.requireNonNull(version);
        setApprovalStatus(approvalStatus);
        setReviewText(reviewText);
        setPublishingDate(publishingDate);
        setFunFact(funFact);
    }

    public Review_Mongo(final Long idReview, final long version, final String approvalStatus, final  String reviewText, final List<Vote> upVote, final List<Vote> downVote, final String report, final LocalDate publishingDate, final String funFact, Product product, Rating rating, User user) {
        this(idReview, version, approvalStatus, reviewText, publishingDate, funFact);

        setUpVote(upVote);
        setDownVote(downVote);
        setReport(report);
        setProduct(product);
        setRating(rating);
        setUser(user);

    }
    public Review_Mongo(final String reviewText, LocalDate publishingDate, Product product, String funFact, Rating rating, User user) {
        this._idReview = Math.abs(new Random().nextLong());
        setReviewText(reviewText);
        setProduct(product);
        setPublishingDate(publishingDate);
        setApprovalStatus("pending");
        setFunFact(funFact);
        setRating(rating);
        setUser(user);
        this._upVote = new ArrayList<>();
        this._downVote = new ArrayList<>();
    }

    public Long getIdReview() {
            return _idReview;
        }
    public String getApprovalStatus() {
            return _approvalStatus;
        }

    public Boolean setApprovalStatus(String approvalStatus) {

        if( approvalStatus.equalsIgnoreCase("pending") ||
            approvalStatus.equalsIgnoreCase("approved") ||
            approvalStatus.equalsIgnoreCase("rejected")) {

            this._approvalStatus = approvalStatus;
            return true;
        }
            return false;
    }

    public String getReviewText() {
            return _reviewText;
        }
    public void setReviewText(String reviewText) {
        if (reviewText == null || reviewText.isBlank()) {
            throw new IllegalArgumentException("Review Text is a mandatory attribute of Review.");
        }
        if (reviewText.length() > 2048) {
            throw new IllegalArgumentException("Review Text must not be greater than 2048 characters.");
        }

        this._reviewText = reviewText;
    }

    public void setReport(String report) {
        if (report.length() > 2048) {
            throw new IllegalArgumentException("Report must not be greater than 2048 characters.");
        }
        this._report = report;
    }

    public LocalDate getPublishingDate() {
            return _publishingDate;
        }
    public void setPublishingDate(LocalDate publishingDate) {
            this._publishingDate = publishingDate;
        }
    public List<Vote> getAcceptance() {
            return _acceptance;
        }
    public void setAcceptance(List<Vote> acceptance) {
            this._acceptance = acceptance;
        }
    public long getVersion() {
            return _version;
        }
    public String getFunFact() {
            return _funFact;
        }

    public void setFunFact(String funFact) {
            this._funFact = funFact;
        }

    public void setProduct(Product product) {
        this._product = new Product_Mongo(product.getSku(),product.getDesignation(),product.getDescription());
    }

    public Product getProduct() {
            return _product;
        }

    public User getUser() {
            return _user;
        }

    public void setUser(User user) {
            this._user = new User_Mongo(user.getUsername(),user.getPassword());
        }

    public Rating getRating() {
        if(_rating == null) {
            return new Rating_Mongo(0.0);
        }
        return _rating;
    }

    public void setRating(Rating rating) {
            this._rating = new Rating_Mongo(rating.getRate());
        }

    public List<Vote> getUpVote() {
            return _upVote != null ? _upVote : new ArrayList<>();
        }

    public void setUpVote(List<Vote> upVote) {
            this._upVote = upVote;
        }

    public List<Vote> getDownVote() {
            return _downVote!= null? _downVote : new ArrayList<>();
        }

    public void setDownVote(List<Vote> downVote) {
            this._downVote = downVote;
        }
    public boolean addUpVote(Vote upVote) {

        if( !this._approvalStatus.equals("approved"))
            return false;

        if(!this._upVote.contains(upVote)){
            this._upVote.add(upVote);
            return true;
        }
            return false;
    }

    public boolean addDownVote(Vote downVote) {

        if( !this._approvalStatus.equals( "approved") )
            return false;

        if(!this._downVote.contains(downVote)){
            this._downVote.add(downVote);
            return true;
        }
            return false;
    }
}
