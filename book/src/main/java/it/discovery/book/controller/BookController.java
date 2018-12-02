package it.discovery.book.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import it.discovery.book.client.StatisticsClient;
import it.discovery.book.domain.Book;
import it.discovery.book.domain.Hit;
import it.discovery.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookRepository bookRepository;

    private final StatisticsClient statisticsClient;

    //@Value("${library.name}")
    private String libraryName;

    @GetMapping("/library")
    public String getLibraryName() {
        return libraryName;
    }

    @PostMapping
    public void saveBook(@RequestBody Book book) {
        bookRepository.saveBook(book);
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @HystrixCommand(fallbackMethod = "getDefaultBook"
            , commandProperties =
    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "5"))
    public Book findById(@PathVariable int id) {
        Book book = bookRepository.findBookById(id);
        if (book != null) {
            addHit(book);
            book.setHitCount(getHitCount(book));
        }
        return book;
    }

    public String getHitCount(Book book) {
        return String.valueOf(statisticsClient.getHitCount(book.getId()));
    }

    public Book getDefaultBook(int id, Throwable ex) {
        log.error(ex.getMessage(), ex);
        Book book = bookRepository.findBookById(id);
        if (book != null) {
            book.setHitCount("N/A");
        }
        return book;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    @PutMapping("{id}")
    public void updateBook(@PathVariable int id, @RequestBody Book book) {
        bookRepository.saveBook(book);
    }

    public void addHit(Book book) {
        Hit hit = new Hit();
        hit.setBrowser("Chrome");
        try {
            hit.setIp(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        hit.setUserName(System.getProperty("user.name"));
        hit.setViewed(LocalDateTime.now());
        hit.setApplicationName("Library client");
        hit.setObjectId(String.valueOf(book.getId()));

        statisticsClient.saveHit(hit);
    }
}
