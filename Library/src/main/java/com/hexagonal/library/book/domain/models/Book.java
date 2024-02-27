package com.hexagonal.library.book.domain.models;

import jakarta.validation.constraints.NotBlank;

public class Book {

    private String id;
    @NotBlank(message = "isbn")
    private String isbn;
    @NotBlank(message = "name")
    private String title;
    @NotBlank(message = "author")
    private String author;

    private int total;
    private int available;

    public Book() {

    }

    public Book(String id, String isbn, String name, String author, int total) {
        this.id = id;
        this.isbn = isbn;
        this.title = name;
        this.author = author;
        this.total = total;
    }

    public Book(String id, String isbn, String name, String author, int total, int available) {
        this.id = id;
        this.isbn = isbn;
        this.title = name;
        this.author = author;
        this.total = total;
        this.available = available;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
