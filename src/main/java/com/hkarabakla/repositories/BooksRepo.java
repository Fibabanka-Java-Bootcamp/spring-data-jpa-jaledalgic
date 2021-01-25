package com.hkarabakla.repositories;

import com.hkarabakla.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepo extends CrudRepository<Book, Integer> {
    Book findByName(String name);

    List<Book> findAllByNameContainingIgnoreCase(String name);
    List<Book> findByAuthors_Name(String name);
    List<Book> findByCategory_Name(String name);
}
