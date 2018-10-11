package com.capgemini.order.service;

import java.util.List;

import com.capgemini.order.entity.Order;

public interface OrderService {
	
	public Order addOrder(Order order);
	public void cancelOrder(int orderId);
	public void deleteOrder(int orderId);
	public Order findOrderbyId(int orderId);
	public List<Order> findAllOrders();
	//	public List<Order> getCustomerOrder(int customerId);
	
}
