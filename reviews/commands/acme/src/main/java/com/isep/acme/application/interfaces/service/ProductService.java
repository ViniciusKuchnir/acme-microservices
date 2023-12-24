package com.isep.acme.application.interfaces.service;

import com.isep.acme.application.dto.products.ProductDTO;
import com.isep.acme.model.Product;
import com.isep.acme.model.ProductDetailDTO;

public interface ProductService {
    void create(final ProductDetailDTO manager);

}
