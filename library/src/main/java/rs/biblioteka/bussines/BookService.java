package rs.biblioteka.bussines;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rs.cubes.biblioteka.domain.Book;
import rs.cubes.biblioteka.domain.Books;

@Stateless
public class BookService {

	private static final Logger logger = LoggerFactory.getLogger(BookService.class);
	
	public BookService() {
		
		logger.info("Defaultni Konstruktor");
		
	}
	
	public Books getAllBooks() {
		
		logger.info("Biznis logika za sve knjige");
		
		Books books = new Books();
		
		String q = "select b from Book b";
		TypedQuery<Book> query = em.createQuery(q, Book.class);
		List<Book> l = query.getResultList();
		
		books.setBooks(l);
		
		return books;
	}
	
	public Book getBook(int id) {
		
		logger.info("Dohvatam knjigu sa id-jem {}.", id);
		
		Book book = em.find(Book.class, id);
		
		return book;
		
	}
	
	public int createBook(Book book) {
		
		em.persist(book);
		
		return book.getId();
	}
	
	public Book updateBook(int id, Book book) {
		
		Book b = em.find(Book.class, id);
		
		b.update(book);
		
		return b;
	}
	
	public void deleteBook(int id) {
		
		Book b = em.find(Book.class, id);
		
		em.remove(b);
	}
	
	@PersistenceContext
	private EntityManager em;
	 
	@EJB
	private Library library;
	
}



