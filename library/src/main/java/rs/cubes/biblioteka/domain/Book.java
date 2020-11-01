package rs.cubes.biblioteka.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	
	private String author;
	
	private String description;
	
	public Book() {
		
	}

	public Book(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

	
    public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void update(Book book) {
		this.setAuthor(book.getAuthor());
		this.setDescription(book.getDescription());
		this.setTitle(book.getTitle());
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}

	
	
	

}
