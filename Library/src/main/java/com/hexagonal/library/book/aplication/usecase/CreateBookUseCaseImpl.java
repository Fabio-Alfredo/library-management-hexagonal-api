package com.hexagonal.library.book.aplication.usecase;

import com.hexagonal.library.book.domain.models.Book;
import com.hexagonal.library.book.domain.ports.in.CreateBookUseCase;
import com.hexagonal.library.book.domain.ports.out.BookRepositoryPort;
import org.springframework.http.ResponseEntity;

public class CreateBookUseCaseImpl implements CreateBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;

    public CreateBookUseCaseImpl(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    public ResponseEntity<Object> createBook(Book book) {
        return bookRepositoryPort.saveBook(book);
    }
}
