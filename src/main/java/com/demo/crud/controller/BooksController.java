package com.demo.crud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crud.model.Books;
import com.demo.crud.service.BooksService;

//mark class as Controller
@RestController
@RequestMapping("/books")
public class BooksController {
//autowire the BooksService class
	@Autowired
	BooksService booksService;

//creating a get mapping that retrieves all the books detail from the database 
	@GetMapping
	private List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

//creating a get mapping that retrieves the detail of a specific book
	@GetMapping("/{bookid}")
	private Books getBooks(@PathVariable("bookid") int bookid) {
		return booksService.getBooksById(bookid);
	}

//creating a delete mapping that deletes a specified book
	@DeleteMapping("/{bookid}")
	private void deleteBook(@PathVariable("bookid") int bookid) {
		booksService.delete(bookid);
	}

//creating post mapping that post the book detail in the database
	@PostMapping
	private int saveBook(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books.getBookid();
	}

//creating put mapping that updates the book detail 
	@PutMapping
	private Books update(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books;
	}
}
