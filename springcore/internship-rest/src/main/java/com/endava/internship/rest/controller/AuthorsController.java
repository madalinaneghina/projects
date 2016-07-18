package com.endava.internship.rest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.endava.internship.rest.model.Author;
import com.endava.internship.rest.model.Book;
import com.endava.internship.rest.model.HelloMessage;
import com.endava.internship.rest.service.AuthorsService;

@RestController
public class AuthorsController {
	@Autowired
	private AuthorsService authorsService;
	
	@RequestMapping(path = "/authors", method = RequestMethod.GET)
	public HttpEntity<Resources<Resource<Author>>> getAuthors(){
		List<Author> authors = this.authorsService.getAuthors();
		
		Resources<Resource<Author>> authorsResources = Resources.wrap(authors);
		authorsResources.add(linkTo(methodOn(AuthorsController.class).getAuthors()).withSelfRel());
		
		for(Resource<Author> authorsResource : authorsResources){
			authorsResource.add(linkTo(methodOn(AuthorsController.class).getAuthor(authorsResource.getContent().getId())).withSelfRel());
		}
		
		return new ResponseEntity<>(authorsResources, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/authors/{authorId}", method = RequestMethod.GET)
	public HttpEntity<Resource<Author>> getAuthor(@PathVariable Integer authorId){
		Author author = this.authorsService.getAuthorById(authorId);
		
		Resource<Author> authorResource = new Resource<>(author);
		authorResource.add(linkTo(methodOn(AuthorsController.class).getAuthor(authorId)).withSelfRel());
		
		return new ResponseEntity<>(authorResource, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/authors", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Resource<Author>> createAuthor(@RequestBody Author author) {
		Author createdAuthor = this.authorsService.createAuthor(author);

        Resource<Author> authorResource = new Resource<>(createdAuthor);
        authorResource.add(linkTo(methodOn(AuthorsController.class).getAuthor(createdAuthor.getId())).withSelfRel());

        return new ResponseEntity<>(authorResource, HttpStatus.CREATED);
    }
	
	@RequestMapping(path = "/authors", method = RequestMethod.DELETE)
	public HttpEntity<Resources<Resource<Author>>> deleteAuthors(){
		if(authorsService.deleteAuthors()){
		return new ResponseEntity<>(HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(path = "/authors/{authorId}", method = RequestMethod.DELETE)
	public HttpEntity<Resource<Author>> deleteAuthor(@PathVariable Integer authorId){
		Author author = this.authorsService.getAuthorById(authorId);
		
		Resource<Author> authorResource = new Resource<>(author);
		authorResource.add(linkTo(methodOn(AuthorsController.class).getAuthor(authorId)).withSelfRel());
		
		return new ResponseEntity<>(authorResource, HttpStatus.OK);
	}

	@RequestMapping(path = "/authors/{authorId}/books", method = RequestMethod.GET)
	public HttpEntity<Resources<Resource<Book>>> getBooks(@PathVariable Integer authorId){
		
		List<Book> books = authorsService.getBooksByAuthor(authorId);
		
		Resources<Resource<Book>> booksResources = Resources.wrap(books);
		booksResources.add(linkTo(methodOn(AuthorsController.class).getBooks(authorId)).withSelfRel());
		
		for(Resource<Book> booksResource : booksResources){
			booksResource.add(linkTo(methodOn(AuthorsController.class).getBook(authorId, booksResource.getContent().getId())).withSelfRel());
		}
		
		return new ResponseEntity<>(booksResources, HttpStatus.OK);
	}
	@RequestMapping(path = "/authors/{authorId}/books/{bookId}", method = RequestMethod.GET)
	public HttpEntity<Resource<Book>> getBook(@PathVariable Integer authorId, @PathVariable Integer bookId){
		
		Book book = authorsService.getBookById(authorId, bookId);
		
		Resource<Book> bookResource = new Resource<>(book);
		bookResource.add(linkTo(methodOn(AuthorsController.class).getBook(authorId, bookId)).withSelfRel());
		
		return new ResponseEntity<>(bookResource, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/authors/{authorId}/books", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Resource<Book>> createBook(@PathVariable Integer authorId, @RequestBody Book book) {
		Book createdBook = authorsService.createBook(authorId, book);

        Resource<Book> bookResource = new Resource<>(createdBook);
        bookResource.add(linkTo(methodOn(AuthorsController.class).getAuthor(createdBook.getId())).withSelfRel());

        return new ResponseEntity<>(bookResource, HttpStatus.CREATED);
    }
}
