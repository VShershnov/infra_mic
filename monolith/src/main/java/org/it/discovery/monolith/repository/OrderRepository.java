package org.it.discovery.monolith.repository;

import org.it.discovery.monolith.domain.Order;

public interface OrderRepository {
	
	void save(Order order);


	Order findById(int orderId);
}
