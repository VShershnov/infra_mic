package it.discovery.order.repository;

import it.discovery.order.domain.Customer;

public interface CustomerRepository {
	
	Customer findById(int customerId);
	

}
