package it.discovery.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
//
//    @Bean
//    @Profile("dev")
//    public InMemoryBookRepository repository() {
//        return null;
//    }
}
