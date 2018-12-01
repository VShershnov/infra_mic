package org.it.discovery.monolith.controller;

import lombok.RequiredArgsConstructor;
import org.it.discovery.monolith.domain.Book;
import org.it.discovery.monolith.repository.BookRepository;
import org.it.discovery.monolith.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shop")
@RequiredArgsConstructor
public class ShopController {
	
	private String libraryName = "IT-Discovery library";
	
	private final BookRepository bookRepository;
	
	private final OrderService orderService;

	@GetMapping("/library")
	public String getLibraryName() {
		return libraryName;
	}

	@GetMapping("book")
	public List<Book> getBooks() {
		return bookRepository.getBooks();				
	}

	@GetMapping("book/{id}")
	public Book getBook(@PathVariable int id) {
		return bookRepository.findBookById(id);				
	}

	@PostMapping("book")
	public void saveBook(@RequestBody Book book) {
		bookRepository.saveBook(book);				
	}

	@PutMapping("book/{id}")
	public void updateBook(@PathVariable int id, @RequestBody Book book) {
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
