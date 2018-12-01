package org.it.discovery.monolith.repository;

import org.it.discovery.monolith.domain.Customer;

public interface CustomerRepository {
	
	Customer findById(int customerId);
	

}
