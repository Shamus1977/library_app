package com.mosby.library.service;

import java.util.List;

import com.mosby.library.dto.AuthorDTO;
import com.mosby.library.entity.Author;
import com.mosby.library.exception.LibraryException;

public interface AuthorService {
	
	public static Author getAuthorOrAuthorDTO(AuthorDTO authorDTO) {
		return new Author(authorDTO.getId(), authorDTO.getName(), 
				authorDTO.getCity(), authorDTO.getCountry());
	}
	
	public static AuthorDTO getAutorOrAuthorDTO(Author author) {
		return new AuthorDTO(author.getId(), author.getName(), 
				author.getCity(), author.getCountry());
	}
	
	public List<AuthorDTO> getAuthors();
	public AuthorDTO getAuthorById(Integer id) throws LibraryException;
	public Integer addAuthor(AuthorDTO authorDTO);
	public Integer deleteAuthor(Integer id);
	
}
