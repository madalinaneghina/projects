package com.endava.internship.rest.model;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private Integer id;
	private String name;
	private List<Book> books = new ArrayList<>();
	
	public Author(){
    	
    }
	public Author(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public void addBook(Book book) {
		books.add(book);
	}
	public Integer getId(){
		return id;
	}
}