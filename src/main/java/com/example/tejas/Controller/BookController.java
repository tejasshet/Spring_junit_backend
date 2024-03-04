package com.example.tejas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tejas.Entity.Book;
import com.example.tejas.Service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;



@Controller
@RequestMapping("/api/books")
public class BookController {
	
    private final BookService bookService = new BookService();
	
	 @PostMapping("/add")
	 public ResponseEntity<Void> addBook(@RequestBody Book book) {
	        bookService.addBook(book);
	        return ResponseEntity.ok().build();
	    }	
}
