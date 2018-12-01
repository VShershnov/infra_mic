package org.it.discovery.monolith.domain;

import lombok.Data;

@Data
public class OrderItem {
	private final Book book;
	
	private final int number;
}
