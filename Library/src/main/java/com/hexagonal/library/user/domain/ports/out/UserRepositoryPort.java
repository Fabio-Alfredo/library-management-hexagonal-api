package com.hexagonal.library.user.domain.ports.out;

import com.hexagonal.library.user.domain.models.User;
import org.springframework.http.ResponseEntity;


public interface UserRepositoryPort {
    ResponseEntity<Object> save (User user);
}
