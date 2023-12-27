package com.isep.acme.model;


import javax.persistence.*;

public abstract class AggregatedRating {

    public abstract double getAverage();

    public abstract void setAverage(double average);

    public abstract Product getProduct();

    public abstract void setProduct(Product product);

    public abstract Long getAggregatedId();

    }
