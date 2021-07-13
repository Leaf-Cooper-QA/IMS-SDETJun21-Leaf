package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Item.class).verify();
	}
	
	@Test
	public void constructor1() {
		Item apple = new Item("apple",1.00);
		assertTrue(apple instanceof Item);
	}
	
	@Test
	public void constructor2() {
		Item apple = new Item(1l,"apple",1.00);
		assertTrue(apple instanceof Item);
	}
	
	@Test
	public void testGetId() {
		Item apple = new Item(1l,"apple",1.00);
		Long expected = 1l;
		assertEquals(expected,apple.getId());
	}
	
	@Test
	public void testSetId() {
		Item apple = new Item("apple",1.00);
		apple.setId(2l);
		Long expected = 2l;
		assertEquals(expected,apple.getId());
	}
	
	@Test
	public void testGetName() {
		Item apple = new Item("apple",1.00);
		String expected = "apple";
		assertEquals(expected,apple.getName());
	}
	
	@Test
	public void testSetName() {
		Item apple = new Item("apple",1.00);
		apple.setName("orange");
		String expected = "orange";
		assertEquals(expected,apple.getName());
	}
	
	@Test
	public void testGetPrice() {
		Item apple = new Item("apple",1.00);
		Double expected = 1.00;
		assertEquals(expected,apple.getPrice());
	}
	
	@Test
	public void testSetPrice() {
		Item apple = new Item("apple",1.00);
		apple.setPrice(4.50);
		Double expected = 4.50;
		assertEquals(expected,apple.getPrice());
	}
	
	@Test
	public void testToString() {
		Item apple = new Item(1l,"apple",1.00);
		String expected = "id:" + apple.getId() + " name:" + apple.getName() + " price:" + apple.getPrice();
		assertEquals(expected,apple.toString());
	}

}
