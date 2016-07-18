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
			if(author.getId() == authorId){
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
		author.addBook(new Book(1, "De la pamant la luna"));
		author.addBook(new Book(2, "Calatorie in jurul pamantului"));
		authors.add(author);
		
		Author author1 = new Author(2, "Ana Blandiana");
		author1.addBook(new Book(1, "Furnicile"));
		authors.add(author1);
		

		Author author2 = new Author(3, "Sandu Alexandra");
		author2.addBook(new Book(1, "Crinul"));
		authors.add(author2);
	}

	public void createAuthor(Author author) {
		authors.add(author);
	}

	public void createBook(Integer authorId, Book book) {
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

	public Book getBookById(Integer authorId, Integer bookId) {
		for(Author author : authors){
			if(author.getId() == authorId){
				for(Book book : author.getBooks()){
					if(book.getId() == bookId){
						return book;
					}
				}
				
			}
		}
		return new Book(0, "Unknown");
	}

	public boolean deleteAuthors() {
		return authors.removeAll(authors);
		
	}

}
