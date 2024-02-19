package com.hexagonal.library.user.infrastructure.adapters;

import com.hexagonal.library.user.domain.models.User;
import com.hexagonal.library.user.domain.ports.out.UserRepositoryPort;
import com.hexagonal.library.user.infrastructure.entities.UserEntity;
import com.hexagonal.library.user.infrastructure.respositories.JpaUserRepository;

public class JpaUserRepositoryAdapter implements UserRepositoryPort {
    private final JpaUserRepository jpaUserRepository;

    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public String save(User user) {
        try{

            if(jpaUserRepository.existsByEmail(user.getEmail())){
                return "new email, email invalid";
            }

            UserEntity userEntity = UserEntity.fromDomainModel(user);
            jpaUserRepository.save(userEntity);
            return "user created";

        }catch (Exception e){
            return "server error";
        }

    }
}
