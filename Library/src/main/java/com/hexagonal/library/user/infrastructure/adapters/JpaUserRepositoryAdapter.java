package com.hexagonal.library.user.infrastructure.adapters;

import com.hexagonal.library.book.infrastructure.entities.BookEntity;
import com.hexagonal.library.book.infrastructure.repositories.JpaBookRepository;
import com.hexagonal.library.exceptions.dto.ExceptionErrorMessage;
import com.hexagonal.library.exceptions.dto.MessageAcceptedService;
import com.hexagonal.library.user.domain.models.User;
import com.hexagonal.library.user.domain.ports.out.UserRepositoryPort;
import com.hexagonal.library.user.infrastructure.entities.UserEntity;
import com.hexagonal.library.user.infrastructure.respositories.JpaUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {
    private final JpaUserRepository jpaUserRepository;
    private final JpaBookRepository jpaBookRepository;

    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository, JpaBookRepository jpaBookRepository) {
        this.jpaUserRepository = jpaUserRepository;
        this.jpaBookRepository = jpaBookRepository;
    }

    @Override
    public ResponseEntity<Object> save(User user) {
        try{

            if(!jpaUserRepository.existsByEmail(user.getEmail())){
                UserEntity userEntity = UserEntity.fromDomainModel(user);
                List<BookEntity>bookEntities = jpaBookRepository.findByNameIn(user.getBooks());

                bookEntities.forEach(book -> book.restBook(1));
                jpaBookRepository.saveAll(bookEntities);
                jpaUserRepository.save(userEntity);
                return  ResponseEntity.ok(new MessageAcceptedService("user created"));

            }
            return ResponseEntity.badRequest().body(new ExceptionErrorMessage("new email, email invalid"));

        }catch (Exception e){
            return ResponseEntity.badRequest().body(new ExceptionErrorMessage("server error"));
        }

    }
}
