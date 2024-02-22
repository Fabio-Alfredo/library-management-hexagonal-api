package com.hexagonal.library.book.domain.ports.in;

import com.hexagonal.library.book.domain.models.Book;
import org.springframework.http.ResponseEntity;

public interface CreateBookUseCase {
    ResponseEntity<Object>createBook(Book book);
}
