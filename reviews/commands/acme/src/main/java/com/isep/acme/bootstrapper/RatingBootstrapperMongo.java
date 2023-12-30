package com.isep.acme.bootstrapper;

import com.isep.acme.application.interfaces.repository.RatingRepositoryMongo;
import com.isep.acme.model.Rating_Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("bootstrap")
public class RatingBootstrapperMongo implements CommandLineRunner {

    @Autowired
    private RatingRepositoryMongo repository;

    @Override
    public void run(String... args) throws Exception {

        if(repository.findByRate(0.5).isEmpty()) {
            Rating_Mongo rate05 = new Rating_Mongo(0.5);
            repository.save(rate05);
        }

        if(repository.findByRate(1.0).isEmpty()) {
            Rating_Mongo rate1 = new Rating_Mongo(1.0);
            repository.save(rate1);
        }

        if(repository.findByRate(1.5).isEmpty()) {
            Rating_Mongo rate15 = new Rating_Mongo(1.5);
            repository.save(rate15);
        }

        if(repository.findByRate(2.0).isEmpty()) {
            Rating_Mongo rate2 = new Rating_Mongo(2.0);
            repository.save(rate2);
        }

        if(repository.findByRate(2.5).isEmpty()) {
            Rating_Mongo rate25 = new Rating_Mongo(2.5);
            repository.save(rate25);
        }

        if(repository.findByRate(3.0).isEmpty()) {
            Rating_Mongo rate3 = new Rating_Mongo(3.0);
            repository.save(rate3);
        }

        if(repository.findByRate(3.5).isEmpty()) {
            Rating_Mongo rate35 = new Rating_Mongo(3.5);
            repository.save(rate35);
        }

        if(repository.findByRate(4.0).isEmpty()) {
            Rating_Mongo rate4 = new Rating_Mongo(4.0);
            repository.save(rate4);
        }

        if(repository.findByRate(4.5).isEmpty()) {
            Rating_Mongo rate45 = new Rating_Mongo(4.5);
            repository.save(rate45);
        }

        if(repository.findByRate(5.0).isEmpty()) {
            Rating_Mongo rate5 = new Rating_Mongo(5.0);
            repository.save(rate5);
        }
    }
}
