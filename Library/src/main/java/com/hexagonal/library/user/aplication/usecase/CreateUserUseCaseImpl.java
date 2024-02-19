package com.hexagonal.library.user.aplication.usecase;

import com.hexagonal.library.user.domain.models.User;
import com.hexagonal.library.user.domain.ports.in.CreateUserUseCase;
import com.hexagonal.library.user.domain.ports.out.UserRepositoryPort;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public CreateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public String createdUser(User user) {
        return userRepositoryPort.save(user);
    }
}
