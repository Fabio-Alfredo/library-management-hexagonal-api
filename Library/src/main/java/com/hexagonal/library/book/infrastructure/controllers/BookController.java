package com.hexagonal.library.book.infrastructure.controllers;

import com.hexagonal.library.book.aplication.service.BookService;
import com.hexagonal.library.book.domain.models.Book;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Object>createdBook(@Valid @RequestBody Book book){
        return bookService.createBook(book);
    }
}
