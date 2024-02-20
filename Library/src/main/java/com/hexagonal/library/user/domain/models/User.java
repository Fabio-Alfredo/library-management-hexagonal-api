package com.hexagonal.library.user.domain.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {
    private String id;
    @NotBlank(message = "insert your name")
    private String name;
    @NotBlank(message = "insert your lastname")
    private String lastname;
    @NotBlank(message = "insert your email")
    private String email;
    @NotBlank(message = "insert your password")
    @Size(min = 6, max = 15, message = "Password must be 6 to 20 characters")
    private String password;

    public User(String id, String name, String lastname, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
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
