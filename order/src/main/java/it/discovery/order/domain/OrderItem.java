package it.discovery.order.domain;

import lombok.Data;

@Data
public class OrderItem {
	private final int bookId;
	
	private final int number;
}
