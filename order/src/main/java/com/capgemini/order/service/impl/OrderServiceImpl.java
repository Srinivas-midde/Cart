package com.capgemini.order.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.order.entity.LineItem;
import com.capgemini.order.entity.Order;
import com.capgemini.order.repository.OrderRepository;
import com.capgemini.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderrepository;
	
	HashMap<Integer, Set<LineItem>> cart = new HashMap<>();
	
	@Override
	public void addLineItem(int customerId, LineItem lineitem) {
		Set<LineItem> tempSet = cart.get(customerId);
		if(tempSet==null) {
			tempSet = new HashSet<>();
			tempSet.add(lineitem);
			cart.put(customerId, tempSet);
		}
		else {
			tempSet.add(lineitem);
			cart.put(customerId, tempSet);
		}
		
	}

	@Override
	public void removeLineItem(int customerId, LineItem lineitem) {
		Set<LineItem> tempSet = cart.get(customerId);
		if(tempSet!=null)
			tempSet.remove(lineitem);
		cart.put(customerId, tempSet);
		
	}

	@Override
	public Set<LineItem> getLineItems(int customerId) {
		Set<LineItem> tempSet = cart.get(customerId);
		return tempSet;
	}

	@Override
	public Order addOrder(int customerId) {
		Order order = new Order();
		order.setCustomerId(customerId);
		order.setItems(cart.get(customerId));
		order.setDate(LocalDate.now());
		order.setTotalPrice(1000);
		return orderrepository.save(order);
	}

	@Override
	public Order cancelOrder(int orderId) {
		return null;
	}

	@Override
	public Order deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOrderbyId(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LineItem> findAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
