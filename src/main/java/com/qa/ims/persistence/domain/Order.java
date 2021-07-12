package com.qa.ims.persistence.domain;

import java.util.Date;
import java.util.Objects;

public class Order {
	
	private long id;
	private Date orderDate;
	private long customerId;
	
	public Order() {
		
	}
	
	public Order(long id, Date orderDate, long customerId) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.customerId = customerId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", order_date=" + orderDate + ", customer_id=" + customerId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, id, orderDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return customerId == other.customerId && id == other.id && Objects.equals(orderDate, other.orderDate);
	}
	
	

}
