package com.qa.ims.controller;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	private ItemController itemCon;
	private CustomerController customerCon;
	private OrderItemsDAO orderItemsDAO;
	private Utils utils;
	private OrderDAO orderDAO;
	
	public OrderController(ItemController itemCon, CustomerController customerCon, OrderItemsDAO orderItemsDAO, OrderDAO orderDAO, Utils utils) {
		super();
		this.itemCon = itemCon;
		this.customerCon = customerCon;
		this.orderItemsDAO = orderItemsDAO;
		this.orderDAO = orderDAO;
		this.utils = utils;
	}


	public OrderController(OrderDAO orderDAO2, Utils utils2) {
		
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
		LOGGER.info("\t1) Please enter the ID of the customer making the order");
		customerCon.readAll();
		Long customerId = utils.getLong();
		
		// create order with customer id
		Order order = orderDAO.create(new Order(customerId));
		
		// add items to order
		addItems(order.getId());
		LOGGER.info("Order created: " + order.toString());
		cost(order);
	
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("\t1) Please enter the id of the order you would like to update");
		this.readAll();
		Long id = utils.getLong();
		LOGGER.info("\t Would you like to add an item to an order or delete an item from an order?");
		LOGGER.info("1) Add an item to order");
		LOGGER.info("2) Delete an item to order");
		
		long selection = utils.getLong();		
		if (selection == 1) {
			addItems(id);
		} else if (selection == 2) {
			deleteItems(id);
		}
		return null;
		
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {

		LOGGER.info("Please enter the id of the order you would like to delete");
		readAll();
		Long id = utils.getLong();
		LOGGER.info("\nOrder deleted: " + id);
		orderItemsDAO.delete(id);
		return orderDAO.delete(id);

	}

	/**
	 * Loop of entering items to order
	 * 
	 */
	public int addItems(Long order_id) {

		System.out.println("Enter the Item ID to add to order " + order_id);
		itemCon.readAll();
		Long item_id = utils.getLong();
		orderItemsDAO.createItemOrder(order_id, item_id);

		System.out.println("\tWould you like to add another item?");
		System.out.println("\tYES = 0 , NO = 1");
		if (utils.getLong() == 0) {
			addItems(order_id);
		} else {
			LOGGER.info("\nOrder function complete.");
		}
		return 0;
	}

	/**
	 * Delete items of a specific order
	 * 
	 */
	public int deleteItems(Long order_id) {

		System.out.println("Enter the Item ID for the item to be deleted");
		itemCon.readAll();
		Long item_id = utils.getLong();
		orderItemsDAO.deleteItem(order_id, item_id);

		LOGGER.info("\nOrder: " + order_id + "\nItem deleted: " + item_id);
		return 0;

	}
	
	/**
	 * Calculate the cost of an order
	 * 
	 */
	public void cost(Order order) {

		List<Double> itemsValues = orderItemsDAO.orderCost(order);

		for (int i = 0; i < (itemsValues.size() - 1); i++) {
			double sum = itemsValues.get(i) + itemsValues.get(i + 1);
			itemsValues.set(i, sum);
			itemsValues.remove(i + 1);
		}

		if (itemsValues.isEmpty()) {
			System.out.println("Cost = £0 (No items added to order)");
		} else {
			System.out.println("The cost of this order is: £" + itemsValues.get(0));
		}

	}

}