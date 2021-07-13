package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem {
	
	private Long id;
	private Long orderId;
	private Long itemId;
	
	public OrderItem(Long id, Long orderId, Long itemId) {
		this.id = id;
		this.orderId = orderId;
		this.itemId = itemId;
	}
	
	public OrderItem(Long orderId, Long itemId) {
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
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemId, other.itemId)
				&& Objects.equals(orderId, other.orderId);
	}

	@Override
	public String toString() {
		return "id:" + id + " orderId:" + orderId + " itemId:" + itemId;
	}
	
	
	
	

}
