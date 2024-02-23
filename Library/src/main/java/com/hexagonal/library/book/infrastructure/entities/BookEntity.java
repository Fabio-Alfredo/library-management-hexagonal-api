package com.hexagonal.library.book.infrastructure.entities;

import com.hexagonal.library.book.domain.models.Book;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Books")
public class BookEntity {
    @Id
    private String id;
    private String isbn;
    private String name;
    private String author;
    private int total;
    private int available;

    public BookEntity() {

    }

    public static BookEntity fromDomainModelBook(Book book){
        return new BookEntity(book.getId(), book.getIsbn(), book.getName(), book.getAuthor(), book.getTotal(), book.getAvailable());
    }

    public static BookEntity fromDomainModelBookUser(Book book){
        return new BookEntity(book.getId(), book.getIsbn(), book.getName(), book.getAuthor());
    }
    public BookEntity(String id, String isbn, String name, String author, int total, int available) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.total = total;
        this.available = available;
    }

    public BookEntity(String id, String isbn, String name, String author) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;

    }


    public void sumBook(int cant){
        if(this.available == 0){
            this.available = cant;
            this.total = cant;
        }else{
            this.available += cant;
            this.total +=cant;
        }

    }

    public void restBook(int cant){
            this.available -= cant;
    }

    public Book toDomainModelBook(){
        return new Book(id, isbn, name, author, total, available);
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
