package com.capgemini.order.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.order.entity.Order;
import com.capgemini.order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
		
	@PutMapping("/cancel/{orderId}")
	public void cancelOrder(@PathVariable int orderId) {
		orderService.cancelOrder(orderId);
	}

	@PostMapping("/order")
	public ResponseEntity<Order> submitOrder(@RequestBody Order order) {
		order.setDate(LocalDate.now());
		order.setStatus("Proccesing");
		order.setTotalPrice(1000);
		return new ResponseEntity<Order>(orderService.addOrder(order), HttpStatus.OK);

	}
	
	@PutMapping("/delete/{orderId}")
	public void deleteOrder(@PathVariable int orderId) {
		orderService.deleteOrder(orderId);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getOrders(){
		return new ResponseEntity<List<Order>>(orderService.findAllOrders(), HttpStatus.OK);
	}
	
}