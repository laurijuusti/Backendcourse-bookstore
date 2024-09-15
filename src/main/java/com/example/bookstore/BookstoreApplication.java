package com.example.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.bookstore.BookRepository;
import com.example.bookstore.domain.Book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

@Bean
    CommandLineRunner initData(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("Tuntematon Sotilas", "Väinö Linna", 1954, 987654, 14.99f));
			bookRepository.save(new Book("Sinuhe Egyptialainen", "Mika Waltari", 1945, 876543, 19.99f));
			bookRepository.save(new Book("Puhdistus", "Sofi Oksanen", 2008, 765432, 12.99f));

            System.out.println("Test data added successfully");
        };
	}
}