package it.discovery.book.repository;

import it.discovery.book.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryBookRepository implements BookRepository {
    private static final String APP_NAME = "Monolith client";

    private final Map<Integer, Book> books;

    private int counter;

    public InMemoryBookRepository() {
        books = new HashMap<>();
        Book book = new Book();
        book.setId(++counter);
        book.setName("Thinking in Java");
        book.setPages(1150);
        book.setYear(2006);
        books.put(book.getId(), book);
    }

    @Override
    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }


    @Override
    public Book findBookById(int id) {
        Book book =  books.get(id);
//        if(book != null) {
//            addHit(book);
//        }

        return book;
    }

    @Override
    public void saveBook(Book book) {
        if(book.getId() == 0) {
            book.setId(++counter);
            books.put(book.getId(), book);
        } else {
            books.put(book.getId(), book);
        }
    }

    @Override
    public void deleteBook(int id) {
        books.remove(id);
    }

}
