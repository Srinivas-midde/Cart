package com.capgemini.order.service;

import java.util.List;
import java.util.Set;

import com.capgemini.order.entity.LineItem;
import com.capgemini.order.entity.Order;

public interface OrderService {
	
	public Order addOrder(int customerId);
	public Order cancelOrder(int orderId);
	public Order deleteOrder(int orderId);
	public Order findOrderbyId(int orderId);
	public List<Order> findAllOrders();
	public void addLineItem(int customerId,LineItem lineitem);
	public List<LineItem> findAllItems();
	void removeLineItem(int customerId, LineItem lineitem);
	public Set<LineItem> getLineItems(int customerId);
}
