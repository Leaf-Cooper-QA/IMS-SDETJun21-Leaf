package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderItemTest {
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(OrderItem.class).verify();
	}
	
	@Test
	public void constructor1() {
		OrderItem oi = new OrderItem(1l,2l,3l);
		assertTrue(oi instanceof OrderItem);
	}
	
	@Test
	public void constructor2() {
		OrderItem oi = new OrderItem(2l,3l);
		assertTrue(oi instanceof OrderItem);
	}
	
	@Test
	public void testGetId() {
		OrderItem oi = new OrderItem(1l,2l,3l);
		Long expected = 1l;
		assertEquals(expected,oi.getId());
	}
	
	@Test
	public void testSetId() {
		OrderItem oi = new OrderItem(1l,2l,3l);
		oi.setId(4l);
		Long expected = 4l;
		assertEquals(expected,oi.getId());
	}
	
	@Test
	public void testGetOrderId() {
		OrderItem oi = new OrderItem(2l,3l);
		Long expected = 2l;
		assertEquals(expected,oi.getOrderId());
	}
	
	@Test
	public void testSetOrderId() {
		OrderItem oi = new OrderItem(2l,3l);
		oi.setOrderId(4l);
		Long expected = 4l;
		assertEquals(expected,oi.getOrderId());
	}
	
	@Test
	public void testGetItemId() {
		OrderItem oi = new OrderItem(2l,3l);
		Long expected = 3l;
		assertEquals(expected,oi.getItemId());
	}
	
	@Test
	public void testSetItemId() {
		OrderItem oi = new OrderItem(2l,3l);
		oi.setItemId(4l);
		Long expected = 4l;
		assertEquals(expected,oi.getItemId());
	}
	
	@Test
	public void testToString() {
		OrderItem oi = new OrderItem(1l,2l,3l);
		String expected = "id:" + oi.getId() + " orderId:" + oi.getOrderId() + " itemId:" + oi.getItemId();
		assertEquals(expected,oi.toString());
	}

}
