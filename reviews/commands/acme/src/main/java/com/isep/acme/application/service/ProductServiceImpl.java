package com.isep.acme.application.service;

import com.isep.acme.application.dto.products.ProductDTO;
import com.isep.acme.application.interfaces.repository.ProductRepository;
import com.isep.acme.application.interfaces.repository.UserRepository;
import com.isep.acme.application.interfaces.service.ProductService;
import com.isep.acme.model.Product;
import com.isep.acme.model.ProductDetailDTO;
import com.isep.acme.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private UserRepository userRepo;


    @Override
    public ProductDTO create(final ProductDetailDTO product) {

            final Product p = new Product(product.getSku(), product.getDesignation(), product.getDescription());
            
            return repository.save(p).toDto();
    }
}
