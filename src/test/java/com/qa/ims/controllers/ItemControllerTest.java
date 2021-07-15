package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private ItemDAO dao;

	@InjectMocks
	private ItemController controller;

	@Test
	public void testCreate() {
		final String name = "i15", type = "Irons", brand = "Ping", shaft = "Stiff";
		final int quantity = 6;
		final double value = 199.99;
		final Item created = new Item(name, value, quantity, type, brand, shaft);

		Mockito.when(utils.getString()).thenReturn(name, type, brand, shaft);
		Mockito.when(utils.getInt()).thenReturn(quantity);
		Mockito.when(utils.getDouble()).thenReturn(value);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(4)).getString();
		Mockito.verify(utils, Mockito.times(1)).getInt();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L, "i15", 199.99, 6, "Irons", "Ping", "Stiff"));

		Mockito.when(dao.readAll()).thenReturn(items);

		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	

	@Test
	public void testUpdate() {
		Item updated = new Item(1L, "Anser", 250.00, 1, "Putter", "Taylormade", "Regular");

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getName(), updated.getType(), updated.getBrand(), updated.getShaft());
		Mockito.when(this.utils.getInt()).thenReturn(updated.getQuantity());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getValue());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(4)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getInt();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
	
}
