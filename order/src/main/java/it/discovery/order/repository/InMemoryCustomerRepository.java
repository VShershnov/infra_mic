package it.discovery.order.repository;

import it.discovery.order.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository{
	
	private final Map<Integer, Customer> customers = new HashMap<>();
	
	public InMemoryCustomerRepository() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("Sam Newman");
		customer.setEmail("sam.newman@gmail.com");
		customers.put(customer.getId(), customer);
	}

	@Override
	public Customer findById(int customerId) {
		return customers.get(customerId);
	}

}
