package com.mosby.library.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mosby.library.dto.AuthorDTO;
import com.mosby.library.dto.BookDTO;
import com.mosby.library.exception.LibraryException;
import com.mosby.library.service.AuthorService;
import com.mosby.library.service.BookService;

@RestController
@RequestMapping("library")
public class LibraryAPI {

	@Autowired
	AuthorService authorService;
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/authors")
	public ResponseEntity<List<AuthorDTO>> getAuthors(){
		List<AuthorDTO> authorDTOs = authorService.getAuthors();
		return new ResponseEntity<List<AuthorDTO>>(authorDTOs, HttpStatus.OK);
	}
	
	@GetMapping("/authors/getAuthorById/{id}")
	public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Integer id) 
			throws LibraryException{
		AuthorDTO authorDTO = authorService.getAuthorById(id);
		return new ResponseEntity<AuthorDTO>(authorDTO, HttpStatus.OK);
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<BookDTO>> getBooks(){
		List<BookDTO> bookDTOs = bookService.getBooks();
		return new ResponseEntity<List<BookDTO>>(bookDTOs,HttpStatus.OK);
	}
	
	@GetMapping("/books/getBookById/{id}")
	public ResponseEntity<BookDTO> getBookById(@PathVariable Integer id) 
			throws LibraryException{
		BookDTO bookDTO = bookService.getBookById(id);
		return new ResponseEntity<BookDTO>(bookDTO,HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<String>("Back of library",HttpStatus.OK);
	}
	
	@PostMapping("/authors/add")
	public ResponseEntity<String> addAuthor(@RequestBody AuthorDTO authorDTO){
		Integer authorId = authorService.addAuthor(authorDTO);
		String message = "Author With Id of: "+authorId+". Has Been Added";
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@PostMapping("books/add")
	public ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO){
		Integer id = bookService.addBook(bookDTO);
		String message = "Book With Id of: "+id+". Has Been Added";
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/authors/delete/{id}")
	public ResponseEntity<String> deleteAuthor(@PathVariable Integer id){
		Integer authorId = authorService.deleteAuthor(id);
		String message = "Author With Id of: "+authorId+". Has Been Deleted";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@DeleteMapping("/books/delete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer id){
		Integer bookId = bookService.deleteBook(id);
		String message = "Book With Id of: "+bookId+". Has Been Deleted";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}
