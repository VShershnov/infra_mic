package it.discovery.book.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Person {
	private int id;
	
	private String name;
	
	private String biography;
	
	private List<Book> books;
	
	private LocalDate birthDate;
	
	private int hitCount;

}
