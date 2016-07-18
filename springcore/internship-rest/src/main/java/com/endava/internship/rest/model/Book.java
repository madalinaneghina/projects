package com.endava.internship.rest.model;

public class Book {
	private String name;
	private Integer id;
	
	public Book(){
		super();
	}

	public Book(Integer id, String name) {
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
	public Integer getId(){
		return id;
	}

}