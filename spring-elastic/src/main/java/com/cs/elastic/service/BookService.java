package com.cs.elastic.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.cs.elastic.model.Book;

/**
 * 
 * @author sanjib.pramanick
 *
 */
public interface BookService extends GenericService<Book, String>{

	Page<Book> findByAuthor(String author, PageRequest pageRequest);

	List<Book> findByTitle(String title);

}