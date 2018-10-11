package com.capgemini.order.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.order.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer>{
	
	@Query("{status : {$eq : 'Deleted'}}")
	public List<Order> find();

}
