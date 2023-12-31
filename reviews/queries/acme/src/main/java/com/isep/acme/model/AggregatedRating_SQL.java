package com.isep.acme.model;

import javax.persistence.*;

@Entity
public class AggregatedRating_SQL extends AggregatedRating{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aggregatedId;

    @Column()
    private double average;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Product_SQL product;

    protected AggregatedRating_SQL() {}

    public AggregatedRating_SQL(double average, Product_SQL product) {
        this.average = average;
        this.product = product;
    }

    @Override
    public double getAverage() {
        return average;
    }

    @Override
    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public void setProduct(Product product) {
        this.product = new Product_SQL(product.getSku(), product.getDesignation(), product.getDescription());
    }

    @Override
    public Long getAggregatedId() {
        return aggregatedId;
    }
}
