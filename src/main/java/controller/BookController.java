package controller;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.impl.BookService;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    //Get all books
    @RequestMapping(value="/books" ,method= RequestMethod.GET)
    public String findAll(Model model){
        model.addAttribute("book", new Book());
        return "index";
    }

    //Register a new book
    @RequestMapping(value="/books/id" ,method= RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book, BindingResult result, Model model){
        model.addAttribute("book", book);

        if (result.hasErrors()){
            return "register";
        } else {
            bookService.saveBook(book);
        }
        return "index";
    }

    //Delete a book
    @RequestMapping(value="/books/id" , method= RequestMethod.DELETE)
    public void deleteBook(Book book){
        bookService.deleteBook(book);
    }

    @RequestMapping(value="/books/id", method= RequestMethod.PUT)
    public Book updateBook(Book book){
        bookService.saveBook(book);
        return book;
    }
}
