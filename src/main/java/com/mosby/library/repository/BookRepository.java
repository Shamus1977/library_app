package com.mosby.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.mosby.library.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
