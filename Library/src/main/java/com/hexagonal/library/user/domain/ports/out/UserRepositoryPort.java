package com.hexagonal.library.user.domain.ports.out;

import com.hexagonal.library.user.domain.models.User;
import org.springframework.stereotype.Component;

@Component
public interface UserRepositoryPort {
    String save (User user);
}
