package com.hexagonal.library.user.infrastructure.adapters;

import com.hexagonal.library.exceptions.dto.ExceptionErrorMessage;
import com.hexagonal.library.exceptions.dto.MessageAcceptedService;
import com.hexagonal.library.user.domain.models.User;
import com.hexagonal.library.user.domain.ports.out.UserRepositoryPort;
import com.hexagonal.library.user.infrastructure.entities.UserEntity;
import com.hexagonal.library.user.infrastructure.respositories.JpaUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {
    private final JpaUserRepository jpaUserRepository;

    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public ResponseEntity<Object> save(User user) {
        try{

            if(!jpaUserRepository.existsByEmail(user.getEmail())){
                UserEntity userEntity = UserEntity.fromDomainModel(user);
                jpaUserRepository.save(userEntity);
                return  ResponseEntity.ok(new MessageAcceptedService("user created"));

            }
            return ResponseEntity.badRequest().body(new ExceptionErrorMessage("new email, email invalid"));

        }catch (Exception e){
            return ResponseEntity.badRequest().body(new ExceptionErrorMessage("server error"));
        }

    }
}
