package com.hexagonal.library.book.infrastructure.repositories;

import com.hexagonal.library.book.infrastructure.entities.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JpaBookRepository extends MongoRepository<BookEntity, Long> {
    boolean existsByName(String name);
    BookEntity findByName(String name);
}
