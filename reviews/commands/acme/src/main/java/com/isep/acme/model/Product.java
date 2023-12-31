package com.isep.acme.model;

import com.isep.acme.application.dto.products.ProductDTO;

import javax.persistence.*;
import java.util.Random;

public abstract class Product {

    public abstract void setSku(String sku) ;
    public abstract String getDesignation();
    public abstract void setDesignation(String designation) ;
    public abstract String getDescription();
    public abstract void setDescription(String description) ;
    public abstract String getSku();
    public abstract void updateProduct(ProductDTO p) ;
    public abstract Long getProductID();

}
