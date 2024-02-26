package com.hexagonal.library.user.infrastructure.respositories;

import com.hexagonal.library.user.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JpaUserRepository extends MongoRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
    UserEntity findByName(String name);
}
