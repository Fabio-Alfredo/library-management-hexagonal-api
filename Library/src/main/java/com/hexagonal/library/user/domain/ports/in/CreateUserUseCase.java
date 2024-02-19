package com.hexagonal.library.user.domain.ports.in;

import com.hexagonal.library.user.domain.models.User;

public interface CreateUserUseCase {
    String createdUser(User user);
}
