package com.hexagonal.library.book.infrastructure.adapters;

import com.hexagonal.library.book.domain.models.Book;
import com.hexagonal.library.book.domain.ports.out.BookRepositoryPort;
import com.hexagonal.library.book.infrastructure.entities.BookEntity;
import com.hexagonal.library.book.infrastructure.repositories.JpaBookRepository;
import com.hexagonal.library.exceptions.dto.ExceptionErrorMessage;
import com.hexagonal.library.exceptions.dto.MessageAcceptedService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class JpaBookRepositoryAdapter implements BookRepositoryPort {

    private final JpaBookRepository jpaBookRepository;

    public JpaBookRepositoryAdapter(JpaBookRepository jpaBookRepository) {
        this.jpaBookRepository = jpaBookRepository;
    }

    @Override
    public ResponseEntity<Object> saveBook(Book book) {
        try {
            BookEntity bookEntity;
            if(jpaBookRepository.existsByTitle(book.getTitle())){
                bookEntity = jpaBookRepository.findByTitle(book.getTitle());
            }else{
                bookEntity = BookEntity.fromDomainModelBook(book);
            }

            String message = (jpaBookRepository.existsByTitle(book.getTitle())) ? "saves" : "saves new book";
            bookEntity.sumBook(book.getTotal(), bookEntity.getTotal());
            jpaBookRepository.save(bookEntity);

            return ResponseEntity.ok(new MessageAcceptedService(message));

        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(new ExceptionErrorMessage("error service"));
        }

    }
}
