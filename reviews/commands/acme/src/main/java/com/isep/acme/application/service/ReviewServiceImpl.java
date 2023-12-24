package com.isep.acme.application.service;

import com.isep.acme.application.dto.reviews.CreateReviewDTO;
import com.isep.acme.application.dto.reviews.ReviewDTO;
import com.isep.acme.application.dto.reviews.VoteReviewDTO;
import com.isep.acme.application.interfaces.service.RatingService;
import com.isep.acme.application.interfaces.service.ReviewService;
import com.isep.acme.application.mapper.ReviewMapper;
import com.isep.acme.controllers.ResourceNotFoundException;
import java.lang.IllegalArgumentException;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isep.acme.model.*;

import com.isep.acme.application.interfaces.repository.ReviewRepository;
import com.isep.acme.application.interfaces.repository.ProductRepository;
import com.isep.acme.application.interfaces.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository repository;

    @Autowired
    ProductRepository pRepository;

    @Autowired
    UserRepository uRepository;

    @Autowired
    UserService userService;

    @Autowired
    RatingService ratingService;

    @Autowired
    RestService restService;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @Override
    public Iterable<Review> getAll() {
        //return repository.findAll();
        throw new NotImplementedException();
    }

    @Override
    public ReviewDTO create(final CreateReviewDTO createReviewDTO, String sku) {
/*
        final Optional<Product> product = pRepository.findBySku(sku);

        if(product.isEmpty()) return null;

        final var user = userService.getUserId(createReviewDTO.getUserID());

        if(user.isEmpty()) return null;

        Rating rating = null;
        Optional<Rating> r = ratingService.findByRate(createReviewDTO.getRating());
        if(r.isPresent()) {
            rating = r.get();
        }

        LocalDate date = LocalDate.now();

        String funfact = restService.getFunFact(date);

        if (funfact == null) return null;

        Review review = new Review(createReviewDTO.getReviewText(), date, product.get(), funfact, rating, user.get());

        review = repository.save(review);

        if (review == null) return null;

        return ReviewMapper.toDto(review);*/
        throw new NotImplementedException();
    }

    @Override
    public List<ReviewDTO> getReviewsOfProduct(String sku, String status) {

        Optional<Product> product = pRepository.findBySku(sku);
        if( product.isEmpty() ) return null;

        Optional<List<Review>> r = repository.findByProductIdStatus(product.get(), status);

        if (r.isEmpty()) return null;

        return ReviewMapper.toDtoList(r.get());
    }

    @Override
    public boolean addVoteToReview(Long reviewID, VoteReviewDTO voteReviewDTO) {
/*
        Optional<Review> review = this.repository.findById(reviewID);

        if (review.isEmpty()) return false;

        Vote vote = new Vote(voteReviewDTO.getVote(), voteReviewDTO.getUserID());
        if (voteReviewDTO.getVote().equalsIgnoreCase("upVote")) {
            boolean added = review.get().addUpVote(vote);
            if (added) {
                Review reviewUpdated = this.repository.save(review.get());
                return reviewUpdated != null;
            }
        } else if (voteReviewDTO.getVote().equalsIgnoreCase("downVote")) {
            boolean added = review.get().addDownVote(vote);
            if (added) {
                Review reviewUpdated = this.repository.save(review.get());
                return reviewUpdated != null;
            }
        }
        return false;*/
        throw new NotImplementedException();
    }

    @Override
    public Double getWeightedAverage(Product product){

        Optional<List<Review>> r = repository.findByProductId(product);

        if (r.isEmpty()) return 0.0;

        double sum = 0;

        for (Review rev: r.get()) {
            Rating rate = rev.getRating();

            if (rate != null){
                sum += rate.getRate();
            }
        }

        return sum/r.get().size();
    }

    @Override
    public Boolean DeleteReview(Long reviewId)  {
/*
        Optional<Review> rev = repository.findById(reviewId);

        if (rev.isEmpty()){
            return null;
        }
        Review r = rev.get();

        if (r.getUpVote().isEmpty() && r.getDownVote().isEmpty()) {
            repository.delete(r);
            return true;
        }
        return false;*/
        throw new NotImplementedException();
    }

    @Override
    public List<ReviewDTO> findPendingReview(){

        Optional<List<Review>> r = repository.findPendingReviews();

        if(r.isEmpty()){
            return null;
        }

        return ReviewMapper.toDtoList(r.get());
    }

    @Override
    public ReviewDTO moderateReview(Long reviewID, VoteReviewDTO voteReviewDTO) throws ResourceNotFoundException, IllegalArgumentException {
/*
        Optional<Review> r = repository.findById(reviewID);

        if(r.isEmpty()){
            throw new ResourceNotFoundException("Review not found");
        }

        var lista = r.get().getAcceptance();

        lista.add(new Vote("accepted",voteReviewDTO.getUserID()));

        r.get().setAcceptance(lista);

        Review review = repository.save(r.get());

        if(lista.size() == 2){
            this.template.convertAndSend(queue.getName(), review.getIdReview());
        }

        return ReviewMapper.toDto(review);*/
        throw new NotImplementedException();
    }


    @Override
    public void acceptReview(Long reviewID) throws ResourceNotFoundException, IllegalArgumentException {
/*
        Optional<Review> r = repository.findById(reviewID);

        if(r.isEmpty()){
            throw new ResourceNotFoundException("Review not found");
        }

        Boolean ap = r.get().setApprovalStatus("approved");

        if(!ap) {
            throw new IllegalArgumentException("Invalid status value");
        }

        repository.save(r.get());*/
        throw new NotImplementedException();
    }

    @Override
    public List<ReviewDTO> findReviewsByUser(Long userID) {
/*
        final Optional<User> user = uRepository.findById(userID);

        if(user.isEmpty()) return null;

        Optional<List<Review>> r = repository.findByUserId(user.get());

        if (r.isEmpty()) return null;

        return ReviewMapper.toDtoList(r.get());*/
        throw new NotImplementedException();
    }
}