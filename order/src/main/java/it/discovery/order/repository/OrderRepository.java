package it.discovery.order.repository;


import it.discovery.order.domain.Order;

public interface OrderRepository {
	
	void save(Order order);


	Order findById(int orderId);
}
