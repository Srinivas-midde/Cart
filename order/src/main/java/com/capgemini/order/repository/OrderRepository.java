package com.capgemini.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.order.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer>{

}
