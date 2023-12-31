package com.isep.acme.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Rating_SQL extends Rating{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRating;

    @Version
    private long version;

    @Column(nullable = false)
    private Double rate;

    protected Rating_SQL(){}

    public Rating_SQL(Long idRating, long version, Double rate) {
        this.idRating = Objects.requireNonNull(idRating);
        this.version = Objects.requireNonNull(version);
        setRate(rate);
    }

    public Rating_SQL(Double rate) {
        setRate(rate);
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}