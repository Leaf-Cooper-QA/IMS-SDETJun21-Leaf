package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Order.class).verify();
	}
	
	@Test
	public void constructor1() {
		Order order = new Order(1l,1l,5.00);
		assertTrue(order instanceof Order);
	}
	
	@Test
	public void constructor2() {
		Order order = new Order(1l,5.00);
		assertTrue(order instanceof Order);
	}
	
	@Test
	public void testGetId() {
		Order order = new Order(1l,1l,5.00);
		Long expected = 1l;
		assertEquals(expected,order.getId());
	}
	
	@Test
	public void testSetId() {
		Order order = new Order(1l,5.00);
		order.setId(2l);
		Long expected = 2l;
		assertEquals(expected,order.getId());
	}
	
	@Test
	public void testGetCustomerId() {
		Order order = new Order(1l,5.00);
		Long expected = 1l;
		assertEquals(expected,order.getCustomerId());
	}
	
	@Test
	public void testSetCustomerId() {
		Order order = new Order(1l,5.00);
		order.setCustomerId(2l);
		Long expected = 2l;
		assertEquals(expected,order.getCustomerId());
	}
	
	@Test
	public void testGetTotal() {
		Order order = new Order(1l,5.00);
		Double expected = 5.00;
		assertEquals(expected,order.getTotal());
	}
	
	@Test
	public void testSetTotal() {
		Order order = new Order(1l,5.00);
		order.setTotal(6.25);
		Double expected = 6.25;
		assertEquals(expected,order.getTotal());
	}
	
	@Test
	public void testToString() {
		Order order = new Order(1l,1l,5.00);
		String expected = "id:" + order.getId() + " customerId:" + order.getCustomerId() + " total:" + order.getTotal();
		assertEquals(expected,order.toString());
	}

}
