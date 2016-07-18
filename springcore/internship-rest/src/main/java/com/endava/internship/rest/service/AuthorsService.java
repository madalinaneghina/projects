package com.endava.internship.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endava.internship.rest.model.Author;
import com.endava.internship.rest.model.Book;
import com.endava.internship.rest.repository.AuthorsRepository;

@Service
public class AuthorsService {
	@Autowired
	private AuthorsRepository authorsRepository;
	
	public List<Author> getAuthors(){
		return authorsRepository.getAuthors();
	}
	
	public Author getAuthorById(Integer authorId){
		return authorsRepository.getAuthorById(authorId);
	}
	
	public List<Book> getBooksByAuthor(Integer authorId){
		return authorsRepository.getBooksByAuthor(authorId);
	}
	public Author addBookToAuthor(Author author, Book book){
		authorsRepository.addBookToAuthor(author, book);
		return author;
	}

	public Author createAuthor(Author author) {
		authorsRepository.createAuthor(author);
		return author;
	}

	public Book createBook(Integer authorId, Book book) {
		authorsRepository.createBook(authorId, book);
		return book;
	}

	public Book getBookById(Integer authorId, Integer bookId) {
		return authorsRepository.getBookById(authorId, bookId);
	}

	public boolean deleteAuthors() {
		return authorsRepository.deleteAuthors();
		
	}
}