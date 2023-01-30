package com.mosby.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mosby.library.dto.AuthorDTO;
import com.mosby.library.entity.Author;
import com.mosby.library.exception.LibraryException;
import com.mosby.library.repository.AuthorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public List<AuthorDTO> getAuthors() {
		List<AuthorDTO> authorDTOs = new ArrayList<AuthorDTO>();
		authorRepository.findAll().forEach((author) ->{
			authorDTOs.add(AuthorService.getAutorOrAuthorDTO(author));
		});
		
		return authorDTOs;
	}
	
	@Override
	public AuthorDTO getAuthorById(Integer id) throws LibraryException {
		Author author = authorRepository.findById(id).orElseThrow(
				() -> new LibraryException("Author not found"));
		AuthorDTO authorDTO = AuthorService.getAutorOrAuthorDTO(author);
		return authorDTO;
	}

	@Override
	public Integer addAuthor(AuthorDTO authorDTO) {
		Author author = new Author(authorDTO.getId(), 
				authorDTO.getName(), authorDTO.getCity(), 
				authorDTO.getCountry());
		return authorRepository.save(author).getId();
	}

	@Override
	public Integer deleteAuthor(Integer id) {
		authorRepository.deleteById(id);
		return id;
	}
}
