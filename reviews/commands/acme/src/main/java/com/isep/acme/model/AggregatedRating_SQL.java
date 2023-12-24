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

}
