package com.hexagonal.library.user.domain.ports.out;

import com.hexagonal.library.user.domain.models.User;

public interface UserRepositoryPort {
    String save (User user);
}
