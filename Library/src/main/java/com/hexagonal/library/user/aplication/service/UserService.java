package com.hexagonal.library.user.aplication.service;

import com.hexagonal.library.user.domain.models.User;
import com.hexagonal.library.user.domain.ports.in.CreateUserUseCase;

public class UserService implements CreateUserUseCase {
    private final CreateUserUseCase createUserUseCase;

    public UserService(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @Override
    public String createdUser(User user) {
        return createUserUseCase.createdUser(user);
    }
}
