package rs.biblioteka.bussines;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rs.cubes.biblioteka.domain.Book;

@Singleton
public class Library {
	
	private static final Logger logger = LoggerFactory.getLogger(Library.class);
	
	private List<Book> books = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		logger.info("Inicijalizujemo biblioteku");
		
		books.add(new Book(1, "Haklberi Fin", "Mark Tvejn"));
		books.add(new Book(2, "Davnicijev kod", "Den Braun"));
		books.add(new Book(3, "Monte Kristo", "Aleksandar Dima"));
		
	}
	
	public List<Book> getAllBooks(){
		
		return books;
	}

	public Book getBook(int id) {
		for(Book b : books) {
			if(b.getId() == id) {
				return b;
			}
		}
		
		return null;
	}
	
}




