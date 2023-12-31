package com.isep.acme.model;


import javax.persistence.*;

public abstract class AggregatedRating {

    private Long aggregatedId;
    private double average;
    private Product product;

    protected AggregatedRating() {}

    public AggregatedRating(double average, Product product) {
        this.average = average;
        this.product = product;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getAggregatedId() {
        return aggregatedId;
    }
}
