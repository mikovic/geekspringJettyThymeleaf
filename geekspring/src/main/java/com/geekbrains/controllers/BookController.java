package com.geekbrains.controllers;

import com.geekbrains.entities.Book;
import com.geekbrains.entities.Student;
import com.geekbrains.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllStudents(Model model, HttpServletRequest httpServletRequest) {

        List<Book> books = (List<Book>) bookService.findAll();
        model.addAttribute("books", books);
        return "books-list";

    }
    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public String getPageStudents(@PathVariable("page") int page, Model model, HttpServletRequest httpServletRequest) {


        Pageable pageable = PageRequest.of(page, 5, Sort.by("title").ascending());
        Page<Book> books = (Page<Book>) bookService.findAll(pageable);
        model.addAttribute("books", books);
        return "books-list";

    }

    @RequestMapping(value = "/between", method = RequestMethod.GET)
    public String getBetweenGradeStudents(@RequestParam(value = "start", required = false) int start,
                                          @RequestParam(value = "end", required = false) int end,Model model, HttpServletRequest httpServletRequest) {

        List<Book> books = (List<Book>) bookService.findAllByPriceBetween(start, end);
        model.addAttribute("books", books);
        return "books-list";

    }
    @RequestMapping(path="/remove/{id}", method=RequestMethod.GET)
    public String removeById(@PathVariable(value = "id") Long id, Model model) {
        bookService.deleteById(id);
        return "redirect:/books/list";
    }
    @RequestMapping(path="/add", method=RequestMethod.GET)
    public String showAddForm(Model model) {
        Book book = new Book();
        book.setTitle("Nobody");
        model.addAttribute("book", book);
        return "add-book-form";
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String showAddForm(Book book) {
        bookService.addBook(book);
        return "redirect:/books/list";
    }

}
