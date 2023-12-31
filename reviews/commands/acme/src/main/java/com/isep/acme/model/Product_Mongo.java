package com.isep.acme.model;

import com.isep.acme.application.dto.products.ProductDTO;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;
import java.util.Random;

@Document(collection="product")
public class Product_Mongo extends Product {

    @Id
    private String _id;
    @Field("_productID")
    private Long _productID;
    @Field("_sku")
    private String _sku;
    private String _designation;
    private String _description;

    protected Product_Mongo() {
        super();
    }

    public Product_Mongo(final Long productID, final String sku) {
        this._productID = Objects.requireNonNull(productID);
        setSku(sku);
    }

    public Product_Mongo(String sku, String designation, String description) {
        this._productID = Math.abs(new Random().nextLong());
        this._sku = sku;
        this._designation = designation;
        this._description = description;
    }

    @Override
    public void setSku(String sku) {
        this._sku = sku;
    }

    @Override
    public String getDesignation() {
        return this._designation;
    }

    @Override
    public void setDesignation(String designation) {
        this._designation = designation;
    }

    @Override
    public String getDescription() {
        return this._description;
    }

    @Override
    public void setDescription(String description) {
        this._description = description;
    }

    @Override
    public String getSku() {
        return this._sku;
    }

    @Override
    public void updateProduct(ProductDTO p) {
        this._sku = p.getSku();
        this._designation = p.getDesignation();
        this._description = p.getDescription();
    }

    @Override
    public Long getProductID() {
        return this._productID;
    }

}