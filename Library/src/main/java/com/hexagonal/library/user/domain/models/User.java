package com.hexagonal.library.user.domain.models;


import com.hexagonal.library.book.domain.models.Book;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class User {
    private String id;
    @NotBlank(message = "insert your name")
    private String name;
    @NotBlank(message = "insert your lastname")
    private String lastname;
    @NotBlank(message = "insert your email")
    @Email(message = "invalid format email")
    private String email;

    private List<String> books;

    public User(String id, String name, String lastname, String email, List<String> books) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.books = books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public List<String> getBooks() {
        return books;
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

}
