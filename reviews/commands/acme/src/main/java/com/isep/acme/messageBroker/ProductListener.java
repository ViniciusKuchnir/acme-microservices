package com.isep.acme.messageBroker;

import com.isep.acme.application.interfaces.service.ProductService;
import com.isep.acme.model.ProductDetailDTO;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "products.v1.product-created")
public class ProductListener {

    @Autowired
    ProductService productService;

    @RabbitHandler
    public void productCreated(ProductDetailDTO productDetailDTO){
        productService.create(productDetailDTO);
    }

}
