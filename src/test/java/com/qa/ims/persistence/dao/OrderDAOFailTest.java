package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOFailTest {
	
	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect("fail");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(3L, 1L, 10.50);
		assertNull(DAO.create(created));
	}
	
	
	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 1L, 5.70));
		expected.add(new Order(2L, 1L, 6.60));
		assertEquals(new ArrayList<>(), DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertNull(DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 2L;
		assertNull(DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Order updated = new Order(3L, 1L, 10.50);
		assertNull(DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(2));
	}
}
