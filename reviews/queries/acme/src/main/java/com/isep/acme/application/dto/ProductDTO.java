package com.isep.acme.application.dto;

public class ProductDTO {
    private String sku;
    private String designation;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductDTO(String sku, String designation) {
        this.sku = sku;
        this.designation = designation;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
