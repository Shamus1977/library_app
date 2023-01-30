package com.mosby.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mosby.library.dto.BookDTO;
import com.mosby.library.entity.Author;
import com.mosby.library.entity.Book;
import com.mosby.library.exception.LibraryException;
import com.mosby.library.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	@Transactional
	public List<BookDTO> getBooks() {
		List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
		bookRepository.findAll().forEach(book->{
			bookDTOs.add(BookService.getBookOrBookDTO(book));
		});
		return bookDTOs;
	}

	@Override
	public BookDTO getBookById(Integer id) throws LibraryException {
		Book book = bookRepository.findById(id).orElseThrow(
				() -> new LibraryException("Book Not Found"));
		BookDTO bookDTO = BookService.getBookOrBookDTO(book);
		return bookDTO;
	}

	@Override
	public Integer addBook(BookDTO bookDTO) {
		Author author = AuthorService.getAuthorOrAuthorDTO(
				bookDTO.getAuthorDTO());
		Book book = BookService.getBookOrBookDTO(bookDTO);
		book.setAuthor(author);
		return bookRepository.save(book).getId();
	}

	@Override
	public Integer deleteBook(Integer id) {
		bookRepository.deleteById(id);
		return id;
	}
}
