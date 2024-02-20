package com.hexagonal.library.user.aplication.service;

import com.hexagonal.library.user.domain.models.User;
import com.hexagonal.library.user.domain.ports.in.CreateUserUseCase;
import org.springframework.http.ResponseEntity;

public class UserService implements CreateUserUseCase {
    private final CreateUserUseCase createUserUseCase;

    public UserService(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @Override
    public ResponseEntity<Object> createdUser(User user) {
        return createUserUseCase.createdUser(user);
    }
}
