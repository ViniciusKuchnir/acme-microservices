package com.isep.acme.application.service;

import com.isep.acme.application.interfaces.repository.ProductRepository;
import com.isep.acme.application.interfaces.repository.ProductRepositoryMongo;
import com.isep.acme.application.interfaces.repository.UserRepository;
import com.isep.acme.application.interfaces.service.ProductService;
import com.isep.acme.model.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductRepositoryMongo productRepositoryMongo;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private UserRepository userRepo;

    @Value("${dataSource}")
    private String dataSource;

    @Override
    public void create(final ProductDetailDTO product) {

        Iterable<Product_SQL> products = repository.findAll();

        final Product p = convertToProductEntity(product);

        if(p instanceof Product_Mongo){
            productRepositoryMongo.save((Product_Mongo) p);
        }else {
            repository.save((Product_SQL) p);
        }
    }

    private Product convertToProductEntity(ProductDetailDTO product) {
        if(dataSource.equalsIgnoreCase("mongodb")){
            return new Product_Mongo(product.getSku(), product.getDesignation(), product.getDescription());
        }else{
            return new Product_SQL(product.getSku(), product.getDesignation(), product.getDescription());
        }
    }
}
