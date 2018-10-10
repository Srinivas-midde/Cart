package com.capgemini.order.entity;

import javax.persistence.Id;

public class LineItem {
	
	@Id
	private int itemId;
	private int quantity;
	private int productId;
	public LineItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LineItem(int itemId, int quantity, int productId) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.productId = productId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "LineItem [itemId=" + itemId + ", quantity=" + quantity + ", productId=" + productId + "]";
	}

	
}
