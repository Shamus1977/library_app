package com.mosby.library.service;

import java.util.List;

import com.mosby.library.dto.AuthorDTO;
import com.mosby.library.dto.BookDTO;
import com.mosby.library.entity.Author;
import com.mosby.library.entity.Book;
import com.mosby.library.exception.LibraryException;

public interface BookService {
	
	public static Book getBookOrBookDTO(BookDTO bookDTO) {
		Author author = AuthorService.getAuthorOrAuthorDTO(bookDTO.getAuthorDTO());
		return new Book(bookDTO.getId(), bookDTO.getTitle(), 
				bookDTO.getDescription(), author);
	}
	
	public static BookDTO getBookOrBookDTO(Book book) {
		AuthorDTO authorDTO = AuthorService.getAutorOrAuthorDTO(book.getAuthor());
		return new BookDTO(book.getId(), book.getTitle(), 
				book.getDescription(), authorDTO);
	}
	
	public List<BookDTO> getBooks();
	public BookDTO getBookById(Integer id) throws LibraryException;
	public Integer addBook(BookDTO bookDTO);
	public Integer deleteBook(Integer id);
}
