package com.capgemini.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.order.entity.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>{

}
