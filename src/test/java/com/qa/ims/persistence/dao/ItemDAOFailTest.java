package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOFailTest {
	
	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect("fail");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item(3L, "pasta", 1.50);
		assertNull(DAO.create(created));
	}
	
	
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "dummy", 1.00));
		expected.add(new Item(2L, "pie", 2.00));
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
		final Item updated = new Item(2L, "pasta", 1.50);
		assertNull(DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(2));
	}

}
