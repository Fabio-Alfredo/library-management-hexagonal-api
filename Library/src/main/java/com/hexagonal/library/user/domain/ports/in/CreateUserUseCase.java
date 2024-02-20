package com.hexagonal.library.user.domain.ports.in;

import com.hexagonal.library.user.domain.models.User;
import org.springframework.http.ResponseEntity;

public interface CreateUserUseCase {
    ResponseEntity<Object> createdUser(User user);
}
