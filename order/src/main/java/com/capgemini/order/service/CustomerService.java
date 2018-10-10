package com.capgemini.order.service;

import com.capgemini.order.entity.Customer;

public interface CustomerService {
	
	public Customer findCustomerById(int customerId);

}
