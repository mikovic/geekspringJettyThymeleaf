package com.geekbrains.services;

import com.geekbrains.entities.Book;
import com.geekbrains.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }
    public List<Book> findAll(Pageable pageable) {
        return (List<Book>) bookRepository.findAll(pageable);
    }
    public List<Book> findAllByPriceBetween(double start, double end) {
        return (List<Book>) bookRepository.findAllByPriceBetween(start, end);
    }
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }
}
