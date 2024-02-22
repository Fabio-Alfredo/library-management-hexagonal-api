package com.hexagonal.library.book.domain.ports.out;

import com.hexagonal.library.book.domain.models.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


public interface BookRepositoryPort {
    ResponseEntity<Object>saveBook(Book book);
}
