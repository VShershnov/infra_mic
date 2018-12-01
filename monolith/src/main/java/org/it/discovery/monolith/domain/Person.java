package org.it.discovery.monolith.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class Person {
	private int id;
	
	private String name;
	
	private String biography;
	
	private List<Book> books;
	
	private LocalDate birthDate;
	
	private List<Hit> hits; 

}
