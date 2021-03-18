package com.demo.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.crud.model.Books;

public interface BooksRepository extends CrudRepository<Books, Integer> {
}
