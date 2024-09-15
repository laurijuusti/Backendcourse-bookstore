package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.example.bookstore.BookRepository;

@Controller
public class BookController {

   private final BookRepository bookRepository;
   public BookController(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
   }


   @RequestMapping(value = "/index", method = RequestMethod.GET)
         public String index() {
            return "indextemplate"; //indextemplate.html
         }
   @RequestMapping(value = "/booklist", method = RequestMethod.GET)
         public String booklist(Model model) {
            model.addAttribute("books", bookRepository.findAll());
            return "booklisttemplate"; //booklisttemplate.html
         }
   

}
