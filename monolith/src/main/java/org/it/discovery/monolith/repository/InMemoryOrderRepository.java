package org.it.discovery.monolith.repository;

import java.util.HashMap;
import java.util.Map;

import org.it.discovery.monolith.domain.Order;

public class InMemoryOrderRepository implements OrderRepository{

	private final Map<Integer, Order> orders = new HashMap<>();

	private int counter;
	
	@Override
	public void save(Order order) {
		if(order.getId() == 0) {
			order.setId(++counter);
			orders.put(order.getId(), order);			
		} else {
			orders.put(order.getId(), order);
		}	
	}

	@Override
	public Order findById(int orderId) {
		return orders.get(orderId);
	}

}
