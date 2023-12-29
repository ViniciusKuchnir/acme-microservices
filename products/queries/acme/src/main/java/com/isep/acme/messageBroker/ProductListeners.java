package com.isep.acme.messageBroker;

import com.isep.acme.services.ProductServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isep.acme.model.Product;
import com.isep.acme.model.ProductDTO;
import com.isep.acme.model.ProductDetailDTO;
import com.isep.acme.repositories.ProductRepository;

import java.io.IOException;

@Component
public class ProductListeners {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @RabbitListener(queues = "products.v1.product-created")
    public void onProductCreated(ProductDetailDTO event){
        Product product = new Product(event.getSku(), event.getDesignation(), event.getDescription());
        try{
            productServiceImpl.create(product);
            System.out.println("CSV EXPORT SUCESSFUL!!!");
        }  catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR EXPORTING CSV");
        }
    }

    @RabbitListener(queues = "products.v1.product-updated")
    public void onProductUpdated(ProductDetailDTO productDetailDTO){
        Product product = new Product(productDetailDTO.getSku(), productDetailDTO.getDesignation(), productDetailDTO.getDescription());
        try{
            productServiceImpl.updateBySku(product.getSku(), product);
            System.out.println("PRODUCT UPDATED!");
        }  catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: PRODUCT NO BE ABLE UPDATED!");
        }
    }

    @RabbitListener(queues = "products.v1.product-deleted")
    public void onProductDeleted(String sku){
        System.out.println("ENTROU NA FUNÇÃO DELETE, MAS NÃO ESTA DELETANDO NA BASE");
    }

}
