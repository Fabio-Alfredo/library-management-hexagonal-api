package com.hexagonal.library.book.infrastructure.repositories;

import com.hexagonal.library.book.infrastructure.entities.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JpaBookRepository extends MongoRepository<BookEntity, Long> {
}
