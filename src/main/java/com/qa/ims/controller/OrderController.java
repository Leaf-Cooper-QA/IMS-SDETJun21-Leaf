package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	
	private OrderDAO orderDAO;
	private ItemDAO itemDAO;
	private OrderItemDAO orderItemDAO;
	private CustomerDAO customerDAO;
	private Utils utils;
	
	

	
	public OrderController(OrderDAO orderDAO, ItemDAO itemDAO, OrderItemDAO orderItemDAO, CustomerDAO customerDAO,
			Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.itemDAO = itemDAO;
		this.orderItemDAO = orderItemDAO;
		this.customerDAO = customerDAO;
		this.utils = utils;
	}

	//Currently just returns the order table. TODO: return contents of each order
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}
	
	@Override
	public Order create() {
		LOGGER.info("Please enter your first name");
		String firstName = utils.getString();
		LOGGER.info("Please enter your surname");
		String surname = utils.getString();
		List<Customer> customers = customerDAO.readAll();
		Long id = (long) -1;
		for (Customer customer : customers) {
			//this part isn't working, not matching the names up
			if (customer.getFirstName().equalsIgnoreCase(firstName) && customer.getSurname().equalsIgnoreCase(surname)) {
				id = customer.getId();
			}
		}
		if (id != -1) {
			Order order = orderDAO.create(new Order(id,(double) 0));
			//start adding items to order
			LOGGER.info("Order started");
			addItem(order);
			return order;
		} else {
			LOGGER.info("No such customer");
			Order order = new Order();
			return order;
		}

	}
	
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order");
		Long orderId = utils.getLong();
		// leaving the customer update part for now, not actually in MVP
		//LOGGER.info("Please enter the id of the customer making the order");
		//Long customerId = utils.getLong(); 
		Order order = orderDAO.read(orderId);
		LOGGER.info("First you will add any new items, then delete any old items. You do not have to both add and remove if you choose not to");
		addItem(order);
		removeItem(order);
		return order;
		
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you wish to delete");
		Long id = utils.getLong();
		List<OrderItem> orderItems = orderItemDAO.readAll();
		for (OrderItem orderItem : orderItems) {
			if (orderItem.getOrderId()== id) {
				orderItemDAO.delete(orderItem.getId());
			}
		}
		return orderDAO.delete(id);
	}
	


	
	public void addItem(Order order) {
		List<Item> items = itemDAO.readAll();
		LOGGER.info("Here are the items you can currently add:");
		for (Item item : items) {
			LOGGER.info(item.getName());
		}
		LOGGER.info("Please enter an item to add. Enter 'Done' when you're finished");
		String newItem = utils.getString();
		if (newItem.equalsIgnoreCase("DONE")) {
			return;
		} else {
			Long itemId = (long) -1;
			for (Item it : items) {
				if (it.getName().equalsIgnoreCase(newItem)) {
					itemId = it.getId();
				}
			}
			
			if (itemId != -1) {
				Item item = itemDAO.read(itemId);
				orderDAO.update(new Order(order.getId(),order.getCustomerId(),order.getTotal()+item.getPrice()));
				orderItemDAO.create(new OrderItem(order.getId(),itemId));
				LOGGER.info("Item added");
				addItem(order);
				return;
			} else {
				LOGGER.info("No such item, please try again");
				addItem(order);
				return;
			}
		}
	}
	
	public void removeItem(Order order) {
		List<Item> items = itemDAO.readAll();
		LOGGER.info("Please enter an item to remove. Enter 'Done' when you're finished");
		String newItem = utils.getString();
		if (newItem.toUpperCase().equalsIgnoreCase("DONE")) {
			return;
		} else {
			Long itemId = (long) -1;
			for (Item it : items) {
				if (it.getName().equalsIgnoreCase(newItem)) {
					itemId = it.getId();
				}
			}
			
			if (itemId != -1) {
				Item item = itemDAO.read(itemId);
				orderDAO.update(new Order(order.getId(),order.getCustomerId(),order.getTotal()-item.getPrice()));
				List<OrderItem> orderItems = orderItemDAO.readAll();
				Long orderItemId = (long) -1;
				for (OrderItem oi :orderItems) {
					if (oi.getOrderId()==order.getId() && oi.getItemId()==itemId) {
						orderItemId = oi.getId();
					}
				}
				
				if (orderItemId != -1) {
					orderItemDAO.delete(orderItemId);
					LOGGER.info("Item removed from order");
					removeItem(order);
					return;
				} else {
					LOGGER.info("Item not in order, please try again");
					removeItem(order);
					return;
				}
	
			} else {
				LOGGER.info("No such item, please try again");
				removeItem(order);
				return;
			}
			
		}
	}
}
