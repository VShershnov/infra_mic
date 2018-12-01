package it.discovery.book.repository;

import it.discovery.book.domain.Book;

import java.util.List;

public interface BookRepository {

    List<Book> getBooks();

    Book findBookById(int id);

    void saveBook(Book book);

    void deleteBook(int id);

}
