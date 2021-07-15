package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
	
	private long id;
	private long customerId;
	
	public Order(long customerId) {
		this.setCustomerId(customerId);
	}
	
	public Order(long id, long customerId) {
		super();
		this.id = id;
		this.customerId = customerId;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer_id=" + customerId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, id);
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
		return customerId == other.customerId && id == other.id;
	}


	

}
