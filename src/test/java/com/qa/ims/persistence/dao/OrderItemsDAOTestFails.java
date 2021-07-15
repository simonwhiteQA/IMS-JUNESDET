package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;

public class OrderItemsDAOTestFails {
	
	private final OrderItemsDAO DAO = new OrderItemsDAO();

	@Before
	public void setup() {
		DBUtils.connect("Fail");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final OrderItems created = new OrderItems(2L, 1L, 1L);
		assertNull(DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<OrderItems> expected = new ArrayList<>();
		expected.add(new OrderItems(1L, 1L, 1L));
		assertTrue(DAO.readAll().isEmpty());
	}

	@Test
	public void testReadLatest() {
		assertNull(DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertNull(DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final OrderItems updated = new OrderItems(1L, 1L, 1L);
		assertNull(DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(1));
	}

}
