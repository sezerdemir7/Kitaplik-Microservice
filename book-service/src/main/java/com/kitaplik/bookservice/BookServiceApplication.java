package com.kitaplik.bookservice;

import com.kitaplik.bookservice.model.Book;
import com.kitaplik.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class BookServiceApplication implements CommandLineRunner{


    private final BookRepository bookRepository;

    public BookServiceApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Book book1=new Book("Beyaz Dis",2000,"Jack London","ABC yayınevi","123456");
        Book book2 = new Book("Hobbit", 2000, "J.R.R Tolkien", "Can Yayınları", "456789");
        Book book3 = new Book("Suc ve ceza", 1997, "Dostoyevski", "YKB Yayınları", "987654");

        List<Book> bookList=bookRepository.saveAll(Arrays.asList(book1,book2,book3));

        System.out.println(bookList);
    }
}
