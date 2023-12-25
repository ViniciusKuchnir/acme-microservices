package com.isep.acme.bootstrapper;

import com.isep.acme.application.interfaces.repository.ReviewRepositoryMongo;
import com.isep.acme.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Profile("mongo")
public class ReviewBootstrapperMongo implements CommandLineRunner {


    @Autowired
    ReviewRepositoryMongo repo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {

        Review_Mongo review = new Review_Mongo(
                "This is a review",
                LocalDate.now(),
                new Product_Mongo("asd578fgh267", "Pen", "very good nice product"),
                "funFact",
                new Rating_Mongo(4.5),
                new User_Mongo("admin1@mail.com", encoder.encode("AdminPW1"),
                        "Jose Antonio", "355489123", "Rua Um")
                );

            repo.save(review);
    }

}
