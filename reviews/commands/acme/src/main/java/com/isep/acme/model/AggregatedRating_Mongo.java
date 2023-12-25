package com.isep.acme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "aggregatedRating")
public class AggregatedRating_Mongo extends AggregatedRating {

    @Id
    private String id;

    @Indexed(unique = true)
    private Long _aggregatedId;

    private double _average;

    private Product_Mongo _product;

    protected AggregatedRating_Mongo() {}

    public AggregatedRating_Mongo(double average, Product_Mongo product) {
        this._average = average;
        this._product = product;
    }

    public double getAverage() {
        return _average;
    }

    public void setAverage(double average) {
        this._average = average;
    }

    @Override
    public Product getProduct() {
        return null;
    }

    @Override
    public void setProduct(Product product) {

    }

    public Long getAggregatedId() {
        return _aggregatedId;
    }

}
