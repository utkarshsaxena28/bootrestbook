package com.api.book;

import java.util.ArrayList;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;

@Component
public class BookService 
{
	/*
	@Autowired
	private BookRepositiory bookRepositiory;
	
	
	 not working
	
	//get all books
	public List<Book> getAllBooks()
	{
		List<Book> list=  (List<Book>) this.bookRepositiory.findAll();
		return list;
	}
	
	//get Single book by id
	public Book getBookById(int id)
	{
		Book book = null;
		book = this.bookRepositiory.findById(id);
		return book;
	}
	
	// adding the book
	public Book addBook(Book b)
	{
		Book result = bookRepositiory.save(b);
		return result;
	}
	
	// deleting the book
	public void deleteBook(int bid) 
	{
		bookRepositiory.deleteById(bid);
	}
	
	//update the Book
	public void updateBook(Book bok, int bookId) 
	{
		bok.setId(bookId);
		bookRepositiory.save(bok);	
	}*/
	
    private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book (2,"Narnia", "C.S Lewis"));
		list.add(new Book (3,"Thermodynamics", "P.K Nag"));
		list.add(new Book (4,"TOM", "S.S ritam"));
	}
	
	
	//get all books
	public List<Book> getAllBooks()
	{
		return list;
	}
	
	//get Single book by id
	public Book getBookById(int id)
	{
		Book book = null;
		book = list.stream().filter(e -> e.getId() ==id).findFirst().get();
		return book;
	}

	// adding the book
	public Book addBook(Book b)
	{
		list.add(b);
		return b;
	}

	// deleting the book
	public void deleteBook(int bid) 
	{
		list = list.stream().filter(b -> b.getId()!=bid).collect(Collectors.toList());	
	}

	// updating the book
	public void updateBook(Book bok, int bookId) 
	{
		list = list.stream().map(b -> {
					if (b.getId()==bookId)
					{
						b.setTitle(bok.getTitle());
						b.setAuthor(bok.getAuthor());
					}
					return b;
			
					}).collect(Collectors.toList());
		
	}
	
	
	
	
}
