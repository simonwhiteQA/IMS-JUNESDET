package com.qa.ims.controller;

import java.sql.Date;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	private static final ItemDAO ItemDAO = new ItemDAO();
	private static final CustomerDAO CustomerDAO = new CustomerDAO();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	/**
	 * Creates an order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("\t1) Please enter order date in format (yyyy-mm-dd)");
		Date orderDate = utils.getDate();
		LOGGER.info("\t2) Please enter the ID of the customer making the order");
		CustomerController c = new CustomerController(CustomerDAO, utils);
		c.readAll();
		Long customerId = utils.getLong();
		
		// create order with date and customer
		Order order = orderDAO.create(new Order(orderDate, customerId));
		
		// add items to order
		LOGGER.info("\t3) Please enter the ID of the item for the order");
		ItemController i = new ItemController(ItemDAO, utils);
		i.readAll();
		addItems(order);
	
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("\t1) Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("\t2) Please enter order date");
		Date orderDate = utils.getDate();
		LOGGER.info("\t3) Please enter the ID of the customer making the order");
		Long customerId = utils.getLong();
		Order order = orderDAO.update(new Order(id, orderDate, customerId));
		LOGGER.info("Order updated: " + order.toString());
		return order;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("\t1) Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}
	
	/**
	 * Loop of entering items to order
	 * 
	 */
	public void addItems(Order order) {
		
		Long item_id = utils.getLong();
		orderDAO.createItemOrder(order.getId(), item_id);
		System.out.println("Items added to order.");
		
		System.out.println("Would you like to add another item?");
		System.out.println("YES = 0 , NO = 1");
		if (utils.getLong() == 0) {
			System.out.println("Enter the item id:");
			addItems(order);
		} else {
			LOGGER.info("Order created: " + order.toString());
		}
	}
		


}