package com.isep.acme.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Review_SQL extends Review{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReview;

    @Version
    private long version;

    @Column(nullable = false)
    private String approvalStatus;

    @Column(nullable = false)
    private String reviewText;

    @ElementCollection
    @Column(nullable = true)
    private List<Vote> upVote;

    @ElementCollection
    @Column(nullable = true)
    private List<Vote> downVote;

    @ElementCollection
    @Column(nullable = true)
    private  List<Vote> acceptance;

    @Column(nullable = true)
    private String report;

    @Column(nullable = true)
    private LocalDate publishingDate;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private String funFact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product_SQL product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User_SQL user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Rating_SQL rating;

    protected Review_SQL(){}

    public Review_SQL(final Long idReview, final long version, final String approvalStatus,
                      final String reviewText, final LocalDate creationDate, final String funFact) {
        this.idReview = Objects.requireNonNull(idReview);
        this.version = Objects.requireNonNull(version);
        setApprovalStatus(approvalStatus);
        setReviewText(reviewText);
        setCreationDate(creationDate);
        setFunFact(funFact);
    }

    public Review_SQL(final Long idReview, final long version, final String approvalStatus,
                      final  String reviewText, final List<Vote> upVote, final List<Vote> downVote,
                      final String report, final LocalDate publishingDate, final String funFact,
                      Product product, Rating rating, User user) {

        this(idReview, version, approvalStatus, reviewText, publishingDate, funFact);

        setUpVote(upVote);
        setDownVote(downVote);
        setReport(report);
        setProduct(product);
        setRating(rating);
        setUser(user);

    }

    public Review_SQL(final String reviewText, LocalDate creationDate, Product product,
                      String funFact, Rating rating, User user) {
        setReviewText(reviewText);
        setProduct(product);
        setCreationDate(creationDate);
        setApprovalStatus("pending");
        setFunFact(funFact);
        setRating(rating);
        setUser(user);
        this.acceptance = new ArrayList<>();
        this.upVote = new ArrayList<>();
        this.downVote = new ArrayList<>();
    }

    @Override
    public Long getIdReview() {
        return idReview;
    }
    @Override
    public String getApprovalStatus() {
        return approvalStatus;
    }
    @Override
    public Boolean setApprovalStatus(String approvalStatus) {

        if( approvalStatus.equalsIgnoreCase("pending") ||
                approvalStatus.equalsIgnoreCase("approved") ||
                approvalStatus.equalsIgnoreCase("rejected")) {

            this.approvalStatus = approvalStatus;
            return true;
        }
        return false;
    }
    @Override
    public String getReviewText() {
        return reviewText;
    }
    @Override
    public void setReviewText(String reviewText) {
        if (reviewText == null || reviewText.isBlank()) {
            throw new IllegalArgumentException("Review Text is a mandatory attribute of Review.");
        }
        if (reviewText.length() > 2048) {
            throw new IllegalArgumentException("Review Text must not be greater than 2048 characters.");
        }

        this.reviewText = reviewText;
    }
    @Override
    public void setReport(String report) {
        if (report.length() > 2048) {
            throw new IllegalArgumentException("Report must not be greater than 2048 characters.");
        }
        this.report = report;
    }
    @Override
    public LocalDate getPublishingDate() {
        return publishingDate;
    }
    @Override
    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }
    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }
    @Override
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    @Override
    public long getVersion() {
        return version;
    }
    @Override
    public String getFunFact() {
        return funFact;
    }
    @Override
    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }
    @Override
    public void setProduct(Product product) {
        this.product = (Product_SQL) product;
    }
    @Override
    public Product getProduct() {
        return product;
    }
    @Override
    public User getUser() {
        return user;
    }
    @Override
    public void setUser(User user) {
        this.user = (User_SQL) user;
    }
    @Override
    public Rating getRating() {
        if(rating == null) {
            return new Rating(0.0);
        }
        return rating;
    }
    @Override
    public void setRating(Rating rating) {
        this.rating = (Rating_SQL) rating;
    }
    @Override
    public List<Vote> getUpVote() {
        return upVote;
    }
    @Override
    public void setUpVote(List<Vote> upVote) {
        this.upVote = upVote;
    }
    @Override
    public List<Vote> getAcceptance() {
        return acceptance;
    }
    @Override
    public void setAcceptance(List<Vote> acceptance) {
        this.acceptance = acceptance;
    }
    @Override
    public List<Vote> getDownVote() {
        return downVote;
    }
    @Override
    public void setDownVote(List<Vote> downVote) {
        this.downVote = downVote;
    }
    @Override
    public boolean addUpVote(Vote upVote) {

        if( !this.approvalStatus.equals("approved"))
            return false;

        if(!this.upVote.contains(upVote)){
            this.upVote.add(upVote);
            return true;
        }
        return false;
    }
    @Override
    public boolean addDownVote(Vote downVote) {

        if( !this.approvalStatus.equals( "approved") )
            return false;

        if(!this.downVote.contains(downVote)){
            this.downVote.add(downVote);
            return true;
        }
        return false;
    }
}
