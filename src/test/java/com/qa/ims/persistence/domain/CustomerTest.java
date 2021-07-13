package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}
	
	@Test
	public void constructor1() {
		Customer leaf = new Customer("Leaf","Cooper");
		assertTrue(leaf instanceof Customer);
	}
	
	@Test
	public void constructor2() {
		Customer leaf = new Customer(1l,"Leaf","Cooper");
		assertTrue(leaf instanceof Customer);
	}
	
	@Test
	public void testGetId() {
		Customer leaf = new Customer(1l,"Leaf","Cooper");
		Long expected = 1l;
		assertEquals(expected, leaf.getId());
	}
	
	@Test
	public void testSetId() {
		Customer leaf = new Customer("Leaf","Cooper");
		leaf.setId(2l);
		Long expected = 2l;
		assertEquals(expected, leaf.getId());
	}
	
	@Test
	public void testGetFirstName() {
		Customer leaf = new Customer("Leaf","Cooper");
		String expected = "Leaf";
		assertEquals(expected, leaf.getFirstName());
	}
	
	@Test
	public void testSetFirstName() {
		Customer leaf = new Customer("Leaf","Cooper");
		leaf.setFirstName("NewLeaf");
		String expected = "NewLeaf";
		assertEquals(expected, leaf.getFirstName());
	}
	
	@Test
	public void testGetSurname() {
		Customer leaf = new Customer("Leaf","Cooper");
		String expected = "Cooper";
		assertEquals(expected, leaf.getSurname());
	}
	
	@Test
	public void testSetSurname() {
		Customer leaf = new Customer("Leaf","Cooper");
		leaf.setSurname("NewCooper");
		String expected = "NewCooper";
		assertEquals(expected, leaf.getSurname());
	}
	
	@Test
	public void testToString() {
		Customer leaf = new Customer(1l,"Leaf","Cooper");
		String expected = "id:" + leaf.getId() + " first name:" + leaf.getFirstName() + " surname:" + leaf.getSurname();
		assertEquals(expected,leaf.toString());
	}

}
