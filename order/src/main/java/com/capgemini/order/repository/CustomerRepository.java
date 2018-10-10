package com.capgemini.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.order.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
