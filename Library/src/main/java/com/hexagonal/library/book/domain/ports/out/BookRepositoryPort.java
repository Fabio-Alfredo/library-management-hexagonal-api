package com.hexagonal.library.book.domain.ports.out;

import com.hexagonal.library.book.domain.models.Book;
import org.springframework.http.ResponseEntity;

public interface BookRepositoryPort {
    ResponseEntity<Object>saveBook(Book book);
}
