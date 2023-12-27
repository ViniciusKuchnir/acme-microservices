package com.isep.acme.messageBroker;

import com.isep.acme.services.ProductCsvWriter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isep.acme.model.Product;
import com.isep.acme.model.ProductDTO;
import com.isep.acme.model.ProductDetailDTO;
import com.isep.acme.repositories.ProductRepository;

import java.io.IOException;

@Component
public class ProductCreatedListener {
    
    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductCsvWriter productCsvWriter;

    @RabbitListener(queues = "products.v1.product-created")
    public ProductDTO onProductCreated(ProductDetailDTO event){
        Product product = new Product(event.getSku(), event.getDesignation(), event.getDescription());
        try{
            productCsvWriter.writeProductToCsv(product, "product.csv");
            System.out.println("CSV EXPORT SUCESSFUL!!!");
        }  catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR EXPORTING CSV");
        }

        return repository.save(product).toDto();
    }
}
