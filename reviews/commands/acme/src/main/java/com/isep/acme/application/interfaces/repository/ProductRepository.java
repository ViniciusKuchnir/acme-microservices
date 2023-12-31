package com.isep.acme.application.interfaces.repository;

import com.isep.acme.model.Product_SQL;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isep.acme.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product_SQL, Long> {
    List<Product> findByDesignation(String designation);

    Optional<Product> findBySku(String sku);

    //Obtain the catalog of products -> Catalog: show sku and designation of all products
    @Query("SELECT p FROM Product_SQL p WHERE p.sku=:sku AND p.description=:description")
    Optional<Product> getCatalog();

    //Obtain the details of products -> Details: show sku, designation and description of all products

    //Delete the product when given the SKU
    @Transactional
    @Modifying
    @Query("DELETE FROM Product_SQL p WHERE p.sku=:sku")
    void deleteBySku(@Param("sku") String sku);

    //Update the product when given the SKU
    @Transactional
    @Modifying
    @Query("UPDATE Product_SQL p SET p.sku = :sku WHERE p.sku=:sku")
    Product updateBySku(@Param("sku") String sku);

    @Query("SELECT p FROM Product_SQL p WHERE p.productID=:productID")
    Optional<Product_SQL> findById(Long productID);

  /*  @Query("SELECT p FROM ProdImage p WHERE p.id=:id")
    Optional<Product> findById(Long  id); */

}

