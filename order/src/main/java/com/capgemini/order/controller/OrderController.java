package com.capgemini.order.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.order.entity.LineItem;
import com.capgemini.order.entity.Order;
import com.capgemini.order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/shopping/{customerId}")
	public ResponseEntity<LineItem> addLineItem(@RequestBody LineItem item, @PathVariable int customerId) {
		orderService.addLineItem(customerId, item);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/shopping/{customerId}")
	public ResponseEntity<Set<LineItem>> getLineItems(@PathVariable int customerId) {
		Set<LineItem> tempSet = orderService.getLineItems(customerId);
		return new ResponseEntity<Set<LineItem>>(tempSet, HttpStatus.OK);
	}

	@DeleteMapping("/shopping/{customerId}")
	public ResponseEntity<Set<LineItem>> removeLineItem(@PathVariable int customerId, @RequestBody LineItem item) {
		orderService.removeLineItem(customerId, item);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/shopping/submitorder/{customerId}")
	public ResponseEntity<Order> submitOrder(@PathVariable int customerId) {
		return new ResponseEntity<Order>(orderService.addOrder(customerId), HttpStatus.OK);

	}
	
}