package com.isep.acme.bootstrapper;

import com.isep.acme.model.Rating_SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.isep.acme.model.Rating;
import com.isep.acme.application.interfaces.repository.RatingRepository;

@Component
public class RatingBootstrapper implements CommandLineRunner {

    @Autowired
    private RatingRepository repository;

    @Override
    public void run(String... args) throws Exception {

        if(repository.findByRate(0.5).isEmpty()) {
            Rating_SQL rate05 = new Rating_SQL(0.5);
            repository.save(rate05);
        }

        if(repository.findByRate(1.0).isEmpty()) {
            Rating_SQL rate1 = new Rating_SQL(1.0);
            repository.save(rate1);
        }

        if(repository.findByRate(1.5).isEmpty()) {
            Rating_SQL rate15 = new Rating_SQL(1.5);
            repository.save(rate15);
        }

        if(repository.findByRate(2.0).isEmpty()) {
            Rating_SQL rate2 = new Rating_SQL(2.0);
            repository.save(rate2);
        }

        if(repository.findByRate(2.5).isEmpty()) {
            Rating_SQL rate25 = new Rating_SQL(2.5);
            repository.save(rate25);
        }

        if(repository.findByRate(3.0).isEmpty()) {
            Rating_SQL rate3 = new Rating_SQL(3.0);
            repository.save(rate3);
        }

        if(repository.findByRate(3.5).isEmpty()) {
            Rating_SQL rate35 = new Rating_SQL(3.5);
            repository.save(rate35);
        }

        if(repository.findByRate(4.0).isEmpty()) {
            Rating_SQL rate4 = new Rating_SQL(4.0);
            repository.save(rate4);
        }

        if(repository.findByRate(4.5).isEmpty()) {
            Rating_SQL rate45 = new Rating_SQL(4.5);
            repository.save(rate45);
        }

        if(repository.findByRate(5.0).isEmpty()) {
            Rating_SQL rate5 = new Rating_SQL(5.0);
            repository.save(rate5);
        }
    }
}
