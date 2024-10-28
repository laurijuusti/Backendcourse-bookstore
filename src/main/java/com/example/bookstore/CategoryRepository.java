package com.example.bookstore;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findByName(String name);
}
