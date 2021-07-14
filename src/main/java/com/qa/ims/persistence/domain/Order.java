package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
	
	private Long id;
	private Long customerId;
	private Double total;
	
	
	public Order(Long id, Long customerId, Double total) {
		this.id = id;
		this.customerId = customerId;
		this.total = total;
	}
	
	public Order(Long customerId, Double total) {
		this.customerId = customerId;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, id, total);
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
		return Objects.equals(customerId, other.customerId) && Objects.equals(id, other.id)
				&& Objects.equals(total, other.total);
	}

	@Override
	public String toString() {
		return "id:" + id + " customerId:" + customerId + " total:" + total;
	}
	
	
	
	

}
