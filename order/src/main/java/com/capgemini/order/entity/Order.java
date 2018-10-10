package com.capgemini.order.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "orders")
public class Order {

	@Id
	private int orderId;
	private double totalPrice;
	@DateTimeFormat(pattern="dd-mm-yyyy")
	private LocalDate date;
	private int customerId;
	private Set<LineItem> items;
	public Order() {
		super();
	}
	public Order(int orderId, double totalPrice, LocalDate date, int customerId, Set<LineItem> items) {
		super();
		this.orderId = orderId;
		this.totalPrice = totalPrice;
		this.date = date;
		this.customerId = customerId;
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalPrice=" + totalPrice + ", date=" + date + ", customerId="
				+ customerId + ", items=" + items + "]";
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Set<LineItem> getItems() {
		return items;
	}
	public void setItems(Set<LineItem> items) {
		this.items = items;
	}
	
		
	
	
}