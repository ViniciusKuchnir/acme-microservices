package com.isep.acme.model;

public class ProductRequest {
    private Product product;
    private User user;

    public ProductRequest(){}

    public ProductRequest(Product product, User user){
        this.product = product;
        this.user = user;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public Product getProduct(){
        return this.product;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    
}
