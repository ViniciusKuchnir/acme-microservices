package com.isep.acme.model;

import com.isep.acme.application.dto.products.ProductDTO;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "Product")
public class Product_SQL extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productID;

    @Column(nullable = false, unique = true)
    public String sku;

    @Column(nullable = false)
    private String designation;

    @Column(nullable = false)
    private String description;

    /*
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> review = new ArrayList<Review>(); */

    protected Product_SQL(){}

    public Product_SQL(String sku, String designation, String description){
        this.productID = Math.abs(new Random().nextLong());
        this.sku = sku;
        this.designation = designation;
        this.description = description;
    }

    public Product_SQL(final String sku, final String designation, final String description, final User createdBy) {
        setSku(sku);
        setDesignation(designation);
        setDescription(description);
    }
    @Override
    public void setSku(String sku) {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU is a mandatory attribute of Product.");
        }
        if (sku.length() != 12) {
            throw new IllegalArgumentException("SKU must be 12 characters long.");
        }

        this.sku = sku;
    }
    @Override
    public String getDesignation() {
        return designation;
    }
    @Override
    public void setDesignation(String designation) {
        if (designation == null || designation.isBlank()) {
            throw new IllegalArgumentException("Designation is a mandatory attribute of Product.");
        }
        if (designation.length() > 50) {
            throw new IllegalArgumentException("Designation must not be greater than 50 characters.");
        }
        this.designation = designation;
    }
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description is a mandatory attribute of Product.");
        }

        if (description.length() > 1200) {
            throw new IllegalArgumentException("Description must not be greater than 1200 characters.");
        }

        this.description = description;
    }

    @Override
    public String getSku() {
        return sku;
    }

    @Override
    public void updateProduct(ProductDTO p) {
        setDesignation(p.getDesignation());
        setDescription(p.getDescription());
    }
    @Override
    public Long getProductID() {
        return productID;
    }

/*
    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }
*/

}
