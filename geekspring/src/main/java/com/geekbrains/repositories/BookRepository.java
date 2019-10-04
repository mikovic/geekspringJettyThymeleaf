package com.geekbrains.repositories;

import com.geekbrains.entities.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    public List<Book> findAllByPriceBetween(double start, double end);
}
