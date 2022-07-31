package com.api.book;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface BookRepositiory extends CrudRepository<Book, Integer> {
	public Book findById(int id);
}
