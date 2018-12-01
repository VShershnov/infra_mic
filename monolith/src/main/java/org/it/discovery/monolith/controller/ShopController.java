package org.it.discovery.monolith.controller;

import java.util.List;

import org.it.discovery.monolith.domain.Book;
import org.it.discovery.monolith.repository.BookRepository;
import org.it.discovery.monolith.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;

public class ShopController {
	
	private String libraryName = "IT-Discovery library";
	
	private BookRepository bookRepository;
	
	private OrderService orderService;

	@GetMapping("/library")
	public String getLibraryName() {
		return libraryName;
	}

	public List<Book> getBooks() {
		return bookRepository.getBooks();				
	}

	public Book getBook(int id) {
		return bookRepository.findBookById(id);				
	}

	public void saveBook(Book book) {
		bookRepository.saveBook(book);				
	}

	public void updateBook(Book book) {
		bookRepository.saveBook(book);				
	}
	
	public int createOrder(int bookId, int number, int customerId) {
		return orderService.createOrder(bookId, number, customerId).getId();		
	}

	public void addBook(int orderId, int bookId, int number) {
		orderService.addBook(orderId, bookId, number);
	}
	
	public void completeOrder(int orderId) {
		orderService.complete(orderId);
	}
	
	public void deliver(int orderId) {
		orderService.deliver(orderId);			
	}
	
	public void cancel(int orderId) {
		orderService.cancel(orderId);
	}

}
