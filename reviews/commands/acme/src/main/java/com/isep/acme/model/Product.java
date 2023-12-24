package com.isep.acme.model;

import com.isep.acme.application.dto.products.ProductDTO;

import javax.persistence.*;
import java.util.Random;

public abstract class Product {

    private String id;
    private Long productID;
    private String sku;
    private String designation;
    private String description;

    public Product(){}

    public Product(String id, Long productID, String sku, String designation, String description){
        this.id = id;
        this.productID = productID;
        this.sku = sku;
        this.designation = designation;
        this.description = description;
    }

    public Product(Long productID, String sku) {
        this.productID = productID;
        this.sku = sku;
    }

    public abstract void setSku(String sku) ;
    public abstract String getDesignation();
    public abstract void setDesignation(String designation) ;
    public abstract String getDescription();
    public abstract void setDescription(String description) ;
    public abstract String getSku();
    public abstract void updateProduct(ProductDTO p) ;
    public abstract Long getProductID();

}
