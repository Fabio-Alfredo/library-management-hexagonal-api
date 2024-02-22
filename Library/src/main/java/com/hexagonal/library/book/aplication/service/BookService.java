package com.hexagonal.library.book.aplication.service;

import com.hexagonal.library.book.domain.models.Book;
import com.hexagonal.library.book.domain.ports.in.CreateBookUseCase;
import org.springframework.http.ResponseEntity;

public class BookService implements CreateBookUseCase {

    private final CreateBookUseCase createBookUseCase;

    public BookService(CreateBookUseCase createBookUseCase) {
        this.createBookUseCase = createBookUseCase;
    }

    @Override
    public ResponseEntity<Object> createBook(Book book) {
        return createBookUseCase.createBook(book);
    }
}
