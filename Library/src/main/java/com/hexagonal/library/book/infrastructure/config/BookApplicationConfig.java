package com.hexagonal.library.book.infrastructure.config;

import com.hexagonal.library.book.aplication.service.BookService;
import com.hexagonal.library.book.aplication.usecase.CreateBookUseCaseImpl;
import com.hexagonal.library.book.domain.ports.in.CreateBookUseCase;
import com.hexagonal.library.book.domain.ports.out.BookRepositoryPort;
import com.hexagonal.library.book.infrastructure.adapters.JpaBookRepositoryAdapter;
import com.hexagonal.library.user.infrastructure.adapters.JpaUserRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookApplicationConfig {

    @Bean
    public BookService bookService(BookRepositoryPort bookRepositoryPort){
        return new BookService(
                new CreateBookUseCaseImpl(bookRepositoryPort)
        );
    }

    @Bean
    public BookRepositoryPort bookRepositoryPort(JpaBookRepositoryAdapter jpaBookRepositoryAdapter){
        return jpaBookRepositoryAdapter;
    }
}
