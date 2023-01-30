package com.mosby.library.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mosby.library.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer>{
	
}
