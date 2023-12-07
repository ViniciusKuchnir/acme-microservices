package com.isep.acme.messageBroker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.isep.acme.model.ProductDetailDTO;

@Component
public class ProductCreatedListener {
    
    @RabbitListener(queues = "products.v1.product-created")
    public void onProductCreated(ProductDetailDTO event){
        System.out.println("ID recebido " + event.getSku());
        System.out.println("ID recebido " + event.getDesignation());
    }
}
