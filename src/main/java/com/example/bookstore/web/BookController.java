package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import com.example.bookstore.domain.Book;

import org.springframework.web.bind.annotation.PathVariable;
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
   @RequestMapping(value = "/addbook", method = RequestMethod.GET)
         public String addbook(Model model) {
            model.addAttribute("book", new Book());
            return "addbook"; //addbook.html
         }
   @RequestMapping(value = "/save", method = RequestMethod.POST)
         public String save(Book book){
         bookRepository.save(book);
         return "redirect:booklist"; //booklist
         }
   @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
         }
}
