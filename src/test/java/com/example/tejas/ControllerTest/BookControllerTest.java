package com.example.tejas.ControllerTest;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.tejas.Controller.BookController;
import com.example.tejas.Entity.Book;
import com.example.tejas.Service.BookService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @Test
    void testGetBookDetails() {
        String bookId = "1";
        Book mockBook = new Book();
        when(bookService.getBookDetails(bookId)).thenReturn(mockBook);

        ResponseEntity<Book> response = bookController.getBookDetails(bookId);

        assertEquals(HttpStatus.OK, response.getStatusCode()); // checks the status code...
        assertEquals(mockBook, response.getBody()); // checks the response body...
        verify(bookService, times(1)).getBookDetails(bookId); // because bookID is unique....
    }
}
