package com.isep.acme.application.service;

import com.isep.acme.application.dto.ReviewDTO;
import com.isep.acme.application.interfaces.service.RatingService;
import com.isep.acme.application.interfaces.service.ReviewService;
import com.isep.acme.application.mapper.ReviewMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.isep.acme.model.*;

import com.isep.acme.application.interfaces.repository.ReviewRepository;
import com.isep.acme.application.interfaces.repository.ProductRepository;
import com.isep.acme.application.interfaces.repository.UserRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Value("${percentagem_upvotes}")
    private double percentagem_upvotes;
    @Value("${numeroVotes}")
    private int numeroVotes;

    @Override
    public Iterable<Review> getAll() {
        return repository.findAll();
    }

    @Override
    public List<ReviewDTO> getReviewsOfProduct(String sku, String status) {

        Optional<Product> product = pRepository.findBySku(sku);
        if (product.isEmpty()) return null;

        Optional<List<Review>> r = repository.findByProductIdStatus(product.get(), status);

        if (r.isEmpty()) return null;

        return ReviewMapper.toDtoList(r.get());
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
    public List<ReviewDTO> findReviewsByUser(Long userID) {

        final Optional<User> user = uRepository.findById(userID);

        if(user.isEmpty()) return null;

        Optional<List<Review>> r = repository.findByUserId(user.get());

        if (r.isEmpty()) return null;

        return ReviewMapper.toDtoList(r.get());
    }

    @Override
    public List<ReviewDTO> getGetTopReviews() {

        List<Review> allReviews = StreamSupport.stream(repository.findAll().spliterator(), false)
                .sorted(Comparator.comparingInt(o -> o.getUpVote().size()))
                .collect(Collectors.toList());

        List<ReviewDTO> res = new ArrayList<>();

        for (var i : allReviews ) {

            int votos_totais = i.getDownVote().size()  + i.getUpVote().size();
            double percentagem =  (double) i.getUpVote().size()*100 / (votos_totais != 0 ? votos_totais : 1);
            if( votos_totais >= numeroVotes && percentagem >= percentagem_upvotes){
                res.add(new ReviewDTO(i.getIdReview(), i.getReviewText(),
                        i.getPublishingDate(), i.getApprovalStatus(), i.getFunFact(),i.getRating().getRate(),votos_totais));
            }
        }
        return res;
    }
}