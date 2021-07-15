package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItems {
	
	private Long id;
	private Long orderId;
	private Long itemId;
	
	public OrderItems(Long orderId, Long itemId) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
	}
	
	public OrderItems(Long id, Long orderId, Long itemId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.itemId = itemId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "OrderItems [id=" + id + ", orderId=" + orderId + ", itemId=" + itemId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemId, orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItems other = (OrderItems) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemId, other.itemId)
				&& Objects.equals(orderId, other.orderId);
	}
	
	

}
