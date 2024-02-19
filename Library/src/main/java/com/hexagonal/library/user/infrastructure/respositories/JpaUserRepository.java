package com.hexagonal.library.user.infrastructure.respositories;

import com.hexagonal.library.user.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
}
