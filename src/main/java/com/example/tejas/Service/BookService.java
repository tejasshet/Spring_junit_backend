package com.example.tejas.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import com.example.tejas.Entity.Book;
@Service
public class BookService {
	
    private String downStreamURL = "http://localhost:8080/books/";
    
    @Value("$downstream.service.url")
	public void setDownStreamURL(String downStreamURL) {
    	this.downStreamURL = downStreamURL;
    }
    
    
    @Autowired
    public RestTemplate restTemplate;

//    @GetMapping("/{id}")
//    public Book getBookDetails(@PathVariable int id, ) {
//    	return restTemplate. 	
    			
    
    public void addBook(Book book) {
        restTemplate.postForObject(downStreamURL, book, Book.class);
    }
}
	