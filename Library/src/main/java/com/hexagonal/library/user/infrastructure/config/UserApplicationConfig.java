package com.hexagonal.library.user.infrastructure.config;

import com.hexagonal.library.user.aplication.service.UserService;
import com.hexagonal.library.user.aplication.usecase.CreateUserUseCaseImpl;
import com.hexagonal.library.user.domain.ports.out.UserRepositoryPort;
import com.hexagonal.library.user.infrastructure.adapters.JpaUserRepositoryAdapter;
import com.hexagonal.library.user.infrastructure.respositories.JpaUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserApplicationConfig {
    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort){
        return new UserService(
                new CreateUserUseCaseImpl(userRepositoryPort)
        );
    }

    @Bean
    public UserRepositoryPort userRepositoryPort(JpaUserRepositoryAdapter jpaUserRepositoryAdapter){
        return jpaUserRepositoryAdapter;
    }
}
