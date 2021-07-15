package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO OrderTestDAO;
	
	@Mock
	private ItemController ItemTestCon;
	
	@Mock
	private CustomerController CustomerTestCon;

	@Mock
	private OrderItemsDAO OrderItemsTestDAO;
	
	@Mock
	private OrderController OrderTestCon;
	
	@InjectMocks
	private OrderController controller;
	

	@Test
	public void testCreate() {
		final Long orderId = 0L;
		final Long custId = 1L;
		final Order created = new Order(orderId, custId);
		final List<Customer> custList = new ArrayList<>();
		final List<Double> valueList = new ArrayList<>();
		
		Mockito.when(CustomerTestCon.readAll()).thenReturn(custList);
		Mockito.when(utils.getLong()).thenReturn(custId);
		Mockito.when(OrderTestDAO.create(Mockito.any(Order.class))).thenReturn(created);
		Mockito.when(OrderItemsTestDAO.orderCost(created)).thenReturn(valueList);
		
		assertEquals(created, controller.create());
		
		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(OrderTestDAO, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L));

		Mockito.when(OrderTestDAO.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(OrderTestDAO, Mockito.times(1)).readAll();
	}
	

	@Test
	public void testUpdateDelete() {
		final Long orderId = 1L;
		final Long itemId = 2L;
		final List<Order> orders = new ArrayList<>();

		Mockito.when(controller.readAll()).thenReturn(orders);
		Mockito.when(this.utils.getLong()).thenReturn(orderId);
		Mockito.when(this.utils.getLong()).thenReturn(2L);
		Mockito.when(controller.deleteItems(itemId)).thenReturn(0);
		
		assertNull(controller.update());

		Mockito.verify(utils, Mockito.times(4)).getLong();
	}
	

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(OrderTestDAO.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(OrderTestDAO, Mockito.times(1)).delete(ID);
	}
	
}