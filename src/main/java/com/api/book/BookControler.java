package com.api.book;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControler 
{
	@Autowired
	private BookService bookService;
	
	/*
	//@RequestMapping(value = "/books", method = RequestMethod.GET)
	//@ResponseBody
	@GetMapping("/books")
	public Book getBooks()
	{
		Book book = new Book();
		book.setId(1);
		book.setTitle("Harry Potter");
		book.setAuthor("J.K. Rolling");
		return book;
	}*/
	
	@GetMapping("/bok")
	public List<Book> getBooks()
	{
		return this. bookService.getAllBooks();
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id)
	{
		return bookService.getBookById(id);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book bk)
	{
		Book b =  this.bookService.addBook(bk);
		System.out.println(bk);
		return b;
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId)
	{
		this.bookService.deleteBook(bookId);
	}
	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book bok, @PathVariable("bookId") int bookId)
	{
		this.bookService.updateBook(bok,bookId);
		return bok;
		
	}

}
