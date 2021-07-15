package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();
	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	/**
	 * Creates an item by taking in user input
	 */
	@Override
	public Item create() {
		itemDAO.readAll();
		LOGGER.info("\t1) Please enter the item name");
		String name = utils.getString();
		LOGGER.info("\t2) Please enter the items value");
		Double value = utils.getDouble();
		LOGGER.info("\t3) Please enter the items quantity");
		int quantity = utils.getInt();
		LOGGER.info("\t4) Please enter the items type");
		String type = utils.getString();
		LOGGER.info("\t5) Please enter the items brand");
		String brand = utils.getString();
		LOGGER.info("\t6) Please enter the items shaft");
		String shaft = utils.getString();
		Item item = itemDAO.create(new Item(name, value, quantity, type, brand, shaft));
		LOGGER.info("Item created: " + item.toString());
		return item;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Item update() {
		itemDAO.readAll();
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("\t1) Please enter the item name");
		String name = utils.getString();
		LOGGER.info("\t2) Please enter the items value");
		Double value = utils.getDouble();
		LOGGER.info("\t3) Please enter the items quantity");
		int quantity = utils.getInt();
		LOGGER.info("\t4) Please enter the items type");
		String type = utils.getString();
		LOGGER.info("\t5) Please enter the items brand");
		String brand = utils.getString();
		LOGGER.info("\t6) Please enter the items shaft");
		String shaft = utils.getString();
		Item item = itemDAO.update(new Item(id, name, value, quantity, type, brand, shaft));
		LOGGER.info("Item updated: " + item.toString());
		return item;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		itemDAO.readAll();
		LOGGER.info("\t1) Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		LOGGER.info("Item deleted: " + id);
		return itemDAO.delete(id);
	}

}