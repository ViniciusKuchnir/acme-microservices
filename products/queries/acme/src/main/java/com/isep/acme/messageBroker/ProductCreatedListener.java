package com.isep.acme.messageBroker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isep.acme.model.Product;
import com.isep.acme.model.ProductDTO;
import com.isep.acme.model.ProductDetailDTO;
import com.isep.acme.repositories.ProductRepository;

@Component
public class ProductCreatedListener {
    
    @Autowired
    private ProductRepository repository;
    
    @RabbitListener(queues = "products.v1.product-created")
    public ProductDTO onProductCreated(ProductDetailDTO event){
        Product product = new Product(event.getSku(), event.getDesignation(), event.getDescription());
        return repository.save(product).toDto();
    }
}
