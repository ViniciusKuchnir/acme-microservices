package com.isep.acme.model;



import javax.persistence.*;
import java.util.Objects;

public abstract class Rating {


    private Long idRating;
    private long version;
    private Double rate;

    protected Rating(){}

    public Rating(Long idRating, long version, Double rate) {
        this.idRating = Objects.requireNonNull(idRating);
        this.version = Objects.requireNonNull(version);
        setRate(rate);
    }

    public Rating(Double rate) {
        setRate(rate);
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
