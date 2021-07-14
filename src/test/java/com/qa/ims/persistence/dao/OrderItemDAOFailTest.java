package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAOFailTest {
	
	private final OrderItemDAO DAO = new OrderItemDAO();

	@Before
	public void setup() {
		DBUtils.connect("fail");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final OrderItem created = new OrderItem(2L, 1L, 1L);
		assertNull(DAO.create(created));
	}
	
	
	@Test
	public void testReadAll() {
		List<OrderItem> expected = new ArrayList<>();
		expected.add(new OrderItem(1L, 1L, 1L));
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
		final OrderItem updated = new OrderItem(2L, 1L, 1L);
		assertNull(DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(2));
	}

}
