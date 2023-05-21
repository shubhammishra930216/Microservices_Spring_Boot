package com.org.shubham.repositories;


import com.org.shubham.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,Long> {

    Product findByProductNameIgnoreCase(String productName);

}
