package com.hexagonal.library.user.aplication.usecase;

import com.hexagonal.library.user.domain.models.User;
import com.hexagonal.library.user.domain.ports.in.CreateUserUseCase;
import com.hexagonal.library.user.domain.ports.out.UserRepositoryPort;
import org.springframework.http.ResponseEntity;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public CreateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public ResponseEntity<Object> createdUser(User user) {
        return userRepositoryPort.save(user);
    }
}
