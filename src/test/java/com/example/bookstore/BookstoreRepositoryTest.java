package com.example.bookstore;

import com.example.bookstore.domain.Book;
import com.example.bookstore.BookRepository;
import com.example.bookstore.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
public class BookstoreRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository; // Assuming you have a CategoryRepository

    @Test
    public void testCreateBook() {
        // Create a category for the book
        Category category = new Category("Fiction");
        categoryRepository.save(category); // Save the category first

        // Create a book with the saved category
        Book book = new Book("Test Title", "Test Author", 2024, 1234567890, 19.99f, category);
        Book savedBook = bookRepository.save(book);
        assertNotNull(savedBook.getId());
    }

    @Test
    public void testDeleteBook() {
        // Create a category for the book
        Category category = new Category("Non-fiction");
        categoryRepository.save(category);

        // Create and save a book
        Book book = new Book("Delete Title", "Author", 2024, 987654321, 29.99f, category);
        Book savedBook = bookRepository.save(book);
        bookRepository.deleteById(savedBook.getId());
        assertFalse(bookRepository.findById(savedBook.getId()).isPresent());
    }

    @Test
    public void testFindByTitle() {
        // Create a category for the book
        Category category = new Category("Science Fiction");
        categoryRepository.save(category);

        // Save a book with the category
        Book book = new Book("Search Title", "Author", 2024, 1122334455, 15.99f, category);
        bookRepository.save(book);

        Book foundBook = bookRepository.findByTitle("Search Title").get(0);
        assertEquals("Search Title", foundBook.getTitle());
    }
}
