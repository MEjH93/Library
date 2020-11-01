package rs.cubes.biblioteka.domain;

import java.util.ArrayList;
import java.util.List;

public class Books {
	
	private List<Book> books;
	
	public Books() {
		books = new ArrayList<>();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	

}
