package com.hexagonal.library.user.infrastructure.entities;

import com.hexagonal.library.user.domain.models.User;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserEntity {

    @Id
    private String id;

    private String name;
    private String lastname;
    private String email;
    private String password;
    public UserEntity() {

    }

    public UserEntity(String id, String name, String lastname, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }



    public static UserEntity fromDomainModel(User user){
        return new UserEntity(user.getId(), user.getName(), user.getLastname(), user.getEmail(), user.getPassword());
    }

    public User toDomainModel(){
        return new User(id, name, lastname, email, password);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
