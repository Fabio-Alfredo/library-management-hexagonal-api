package com.hexagonal.library.book.domain.models;

public class Book {
    private String id;
    private String isbn;
    private String name;
    private String author;

    public Book(String id, String isbn, String name, String author) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
