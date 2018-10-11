package com.capgemini.order.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.order.entity.Order;
import com.capgemini.order.repository.OrderRepository;
import com.capgemini.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderrepository;

	@Override
	public Order addOrder(Order order) {
		return orderrepository.save(order);
	}

	@Override
	public void cancelOrder(int orderId) {
		Order order = findOrderbyId(orderId);
		order.setStatus("Cancel");
		addOrder(order);
		
	}

	@Override
	public void deleteOrder(int orderId) {
		Order order = findOrderbyId(orderId);
		order.setStatus("Deleted");
		addOrder(order);
	}

	@Override
	public Order findOrderbyId(int orderId) {
		Optional<Order> order = orderrepository.findById(orderId);
		if(order.isPresent())
			return order.get();
		return null;
	}

	@Override
	public List<Order> findAllOrders() {
		return orderrepository.find();
	}
}
