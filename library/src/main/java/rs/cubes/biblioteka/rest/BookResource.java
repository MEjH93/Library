package rs.cubes.biblioteka.rest;


import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rs.biblioteka.bussines.BookService;
import rs.cubes.biblioteka.domain.Book;
import rs.cubes.biblioteka.domain.Books;

@Path("/book")
public class BookResource {
	
	private static final Logger logger = LoggerFactory.getLogger(BookResource.class);
	
	@GET
	@Produces("application/json")
	public Books getBooks() {
		
		Books books = new Books();
		
		books = bookService.getAllBooks();
		
		return books;
	} 

	@GET
	@Produces("application/json")
	@Path("/{id}")
	public Book getBook( @PathParam("id") int id) {
		
		logger.info("Prosledjeni id je {}. ", id);
		
		Book book = bookService.getBook(id);
		
		if(book == null) {
			throw new WebApplicationException("Takva knjiga ne postoji");
		}
		
		return book;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Book createBook(Book book) {
		
		logger.info("Kreira se knjiga {}.", book);
		bookService.createBook(book);
		return book;
	}
	
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("{id}")
	public Book updateBook(@PathParam("id") int id, Book book) {
		
		logger.info("Azurira se knjiga sa id-jem {} na sledece {}.", id, book);
		
		book = bookService.updateBook(id, book);
		return book;
	}
	
	@DELETE
	public void deleteAllBooks() {
		
		logger.info("Brisanje svih knjiga");
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") int id) {
		
		logger.info("Brisanje knjige sa id-jem {}", id);
		bookService.deleteBook(id);
	}
	
	@EJB
	private BookService bookService;
	
	
}





