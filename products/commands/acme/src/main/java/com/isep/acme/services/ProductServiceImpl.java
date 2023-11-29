package com.isep.acme.services;

import com.isep.acme.model.Product;
import com.isep.acme.model.ProductDTO;
import com.isep.acme.model.ProductDetailDTO;
import com.isep.acme.model.User;
import com.isep.acme.repositories.ProductRepository;
import com.isep.acme.repositories.UserRepository;

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
    public ProductDTO create(final Product product, final Long userId) {

            Optional<User> userOptional = userRepo.findById(userId);
            User user = userOptional.orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + userId)); 

            final Product p = new Product(product.getSku(), product.getDesignation(), product.getDescription(), user);
            //QueueName
            String routingKey = "products.v1.product-created";
            
            ProductDetailDTO event = new ProductDetailDTO(product.getSku(), product.getDesignation(), product.getDescription());

            rabbitTemplate.convertAndSend(routingKey, event);
        return repository.save(p).toDto();
    }

    @Override
    public void approveProduct(String sku, Long userId){
        Optional<Product> product = repository.findBySku(sku);
        Optional<User> user = userRepo.findById(userId);

        if (user.get().getRole().getId() == 1 && product.get().getCreatedBy() != user.get()) {
            product.get().setNumberApprovals(product.get().getNumberApprovals() + 1);
            repository.save(product.get());
        }
    }

    @Override
    public ProductDTO updateBySku(String sku, Product product) {
        
        final Optional<Product> productToUpdate = repository.findBySku(sku);

        if( productToUpdate.isEmpty() ) return null;

        productToUpdate.get().updateProduct(product);

        Product productUpdated = repository.save(productToUpdate.get());
        
        return productUpdated.toDto();
    }

    @Override
    public void deleteBySku(String sku) {
        repository.deleteBySku(sku);
    }
}
