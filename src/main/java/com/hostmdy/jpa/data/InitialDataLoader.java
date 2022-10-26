package com.hostmdy.jpa.data;



import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.hostmdy.jpa.entity.Author;
import com.hostmdy.jpa.entity.Book;
import com.hostmdy.jpa.repository.AuthorRepository;
import com.hostmdy.jpa.repository.BookRepository;
@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent>{

	private BookRepository bookrepository;
	private AuthorRepository authorrepository;
	
	
	public InitialDataLoader(BookRepository bookrepository, AuthorRepository authorrepository) {
		super();
		this.bookrepository = bookrepository;
		this.authorrepository = authorrepository;
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initialize();
	}
	private void initialize() {
		Book book1 = new Book("Domain Driven Design","programming",34);
		Author author1 = new Author("Eric","Evan",60,"eric.evan@gmail.com");
		//Man
		book1.getAuthors().add(author1);
		author1.getBooks().add(book1);
		authorrepository.save(author1);
		bookrepository.save(book1);//create insert
		
		
		Book book3 = new Book("Java 8 in action","Programming",34);
		Author author3 = new Author("Jhon","Doe",50,"jhon.evan@gmail.com");
		//ManyToMany Connect
		book3.getAuthors().add(author3);
		author3.getBooks().add(book3);
		authorrepository.save(author3);
		bookrepository.save(book3);//create insert
		
		
		Book book2 = new Book("Modern Design Programming","Programming",34);
		Author author2 = new Author("lily","Evan",60,"lily.evan@gmail.com");
		//Man
		book2.getAuthors().add(author2);
		author2.getBooks().add(book2);
		authorrepository.save(author2);
		bookrepository.save(book2);//create insert
		
		Book book4 = new Book("Java MultiThreading","Programming",40);
		book4.getAuthors().add(author1);
		book4.getAuthors().add(author2);
		book4.getAuthors().add(author3);
		authorrepository.save(author1);
		authorrepository.save(author2);
		authorrepository.save(author3);
		bookrepository.save(book4);
		
	}
}
