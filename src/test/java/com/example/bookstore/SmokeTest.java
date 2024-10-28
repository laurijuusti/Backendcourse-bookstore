package com.example.bookstore;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
@AutoConfigureMockMvc
public class SmokeTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testBookListController() throws Exception {
        mockMvc.perform(get("/booklist"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCategoryListController() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @WithMockUser(username = "admin", password = "admin")
    @Test
    public void testAddBookController() throws Exception {
        mockMvc.perform(get("/addbook"))
                .andExpect(status().isOk());
    }

    @WithMockUser(username = "admin", password = "admin")
    @Test
    public void testAddCategoryController() throws Exception {
        mockMvc.perform(get("/addcategory"))
                .andExpect(status().isOk());
    }

}
