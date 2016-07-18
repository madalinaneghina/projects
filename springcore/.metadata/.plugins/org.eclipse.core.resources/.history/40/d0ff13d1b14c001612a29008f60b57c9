package com.endava.internship.rest.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.endava.internship.rest.model.Author;
import com.endava.internship.rest.model.Book;

@Repository
public class AuthorsRepository {
	private List<Author> authors;

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public Author getAuthorById(Integer authorId){
		for(Author author : authors){
			if(author.getId().equals(authorId)){
				return author;
			}
		}
		return new Author(0, "Anonim");
	}
	
	public void addBookToAuthor(Author author, Book book){
		for(Author anAuthor : authors){
			if(anAuthor.getId() == author.getId()){
				anAuthor.addBook(book);
			}
		}
	}
	@PostConstruct
	public void init(){
		authors = new ArrayList<>();
		
		Author author = new Author(1, "Jules Verne");
		authors.add(author);
		
		author = new Author(2, "Ana Blandiana");
		author.addBook(new Book("Furnicile"));
	}

	public void createAuthor(Author author) {
		// TODO Auto-generated method stub
		
		authors.add(author);
		
	}

	public void createBook(Integer authorId, Book book) {
		// TODO Auto-generated method stub
		
		for(Author author : authors){
			if(author.getId() == authorId){
				author.addBook(book);
			}
		}
		
	}

	public List<Book> getBooksByAuthor(Integer authorId) {
		List<Book> books = new ArrayList<>();
		for(Author author : authors){
			if(author.getId() == authorId){
				return author.getBooks();
			}
		}
		return books;
	}

}
