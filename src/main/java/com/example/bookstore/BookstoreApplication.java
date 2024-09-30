package com.example.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.bookstore.BookRepository;
import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return args -> {

			Category scifi = new Category("Scifi");
			Category comic = new Category("Comic");
			Category novel = new Category("Novel");

			categoryRepository.save(scifi);
			categoryRepository.save(comic);
			categoryRepository.save(novel);

			bookRepository.save(new Book("Tuntematon Sotilas", "Väinö Linna", 1954, 987654, 14.99f, novel));
			bookRepository.save(new Book("Sinuhe Egyptialainen", "Mika Waltari", 1945, 876543, 19.99f, novel));
			bookRepository.save(new Book("Puhdistus", "Sofi Oksanen", 2008, 765432, 12.99f, novel));

			System.out.println("Book test data and categories added successfully");
		};
	}
}