package com.isep.acme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "rating")
public class Rating_Mongo extends Rating{
    @Id
    private String id;

    @Indexed(unique = true)
    private Long _idRating;
    private long _version;
    private Double _rate;
    protected Rating_Mongo(){}

    public Rating_Mongo(Long idRating, long version, Double rate) {
        this._idRating = Objects.requireNonNull(idRating);
        this._version = Objects.requireNonNull(version);
        setRate(rate);
    }

    public Rating_Mongo(Double rate) {
        setRate(rate);
    }

    public Long getIdRating() { return _idRating;}
    public Double getRate() {
        return _rate;
    }

    public void setRate(Double rate) {
        this._rate = rate;
    }

}
