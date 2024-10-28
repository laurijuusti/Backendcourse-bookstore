package com.example.bookstore;

import com.example.bookstore.domain.Category;
import com.example.bookstore.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testCreateCategory() {
        Category category = new Category("Fiction");
        Category savedCategory = categoryRepository.save(category);
        assertNotNull(savedCategory.getCategoryId());
    }

    @Test
    public void testDeleteCategory() {
        Category category = new Category("Non-fiction");
        Category savedCategory = categoryRepository.save(category);
        categoryRepository.deleteById(savedCategory.getCategoryId());
        assertFalse(categoryRepository.findById(savedCategory.getCategoryId()).isPresent());
    }

    @Test
    public void testFindByName() {
        Category category = new Category("Science Fiction");
        categoryRepository.save(category);
        Category foundCategory = categoryRepository.findByName("Science Fiction").get(0);
        assertEquals("Science Fiction", foundCategory.getName());
    }
}
