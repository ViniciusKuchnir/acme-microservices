package com.isep.acme.model;

import com.isep.acme.application.dto.ProductDTO;

import javax.persistence.*;

@Entity
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productID;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private String designation;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "number_approvals")
    private Integer numberApprovals = 0;

    /*
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> review = new ArrayList<Review>(); */

    protected Product(){}

    public Product(final String sku, final String designation, final String description, final User createdBy) {
        setSku(sku);
        setDesignation(designation);
        setDescription(description);
        this.createdBy = createdBy;
    }

    public void setSku(String sku) {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU is a mandatory attribute of Product.");
        }
        if (sku.length() != 12) {
            throw new IllegalArgumentException("SKU must be 12 characters long.");
        }

        this.sku = sku;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        if (designation == null || designation.isBlank()) {
            throw new IllegalArgumentException("Designation is a mandatory attribute of Product.");
        }
        if (designation.length() > 50) {
            throw new IllegalArgumentException("Designation must not be greater than 50 characters.");
        }
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description is a mandatory attribute of Product.");
        }

        if (description.length() > 1200) {
            throw new IllegalArgumentException("Description must not be greater than 1200 characters.");
        }

        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public User getCreatedBy(){
        return this.createdBy;
    }

    public Integer getNumberApprovals(){
        return this.numberApprovals;
    }

    public void setNumberApprovals(Integer numberApprovals){
        this.numberApprovals = numberApprovals;
    }

    public void updateProduct(Product p) {
        setDesignation(p.designation);
        setDescription(p.description);

    }

    public abstract void updateProduct(ProductDTO p);

    public Long getProductID() {
        return productID;
    }

    public ProductDTO toDto() {
        return new ProductDTO(this.sku, this.designation);
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
