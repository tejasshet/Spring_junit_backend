package com.example.tejas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.example.tejas.Entity.Book;

import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${downstream.service.url}") // Fix the annotation typo here
	private String downStreamURL = "http://localhost:9090/books";
    
	public void setDownStreamURL(String downStreamURL) {
    	this.downStreamURL = downStreamURL;
    }
   
	// To get all the books
	public Book getBookDetails(String bookId) {
        return restTemplate.getForObject(downStreamURL + "/" + bookId, Book.class);
	}

	// To add books
	public Book addBook(Book book) {	
		return restTemplate.postForObject(downStreamURL, book, Book.class);
	}
}
