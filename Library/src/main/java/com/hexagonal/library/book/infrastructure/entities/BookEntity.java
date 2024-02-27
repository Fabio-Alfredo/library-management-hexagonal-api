package com.hexagonal.library.book.infrastructure.entities;

import com.hexagonal.library.book.domain.models.Book;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Books")
public class BookEntity {
    @Id
    private String id;
    private String isbn;
    private String title;
    private String author;
    private int total;
    private int available;

    public BookEntity() {

    }

    public static BookEntity fromDomainModelBook(Book book){
        return new BookEntity(book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor(), book.getTotal(), book.getAvailable());
    }
    public BookEntity(String id, String isbn, String name, String author, int total, int available) {
        this.id = id;
        this.isbn = isbn;
        this.title = name;
        this.author = author;
        this.total = total;
        this.available = available;
    }


    public void sumBook(int total, int dispo){
        if(this.available == 0){
            this.available = dispo;
            this.total = total;
        }else{
            this.available += dispo;
            this.total +=total;
        }

    }
    public Book toDomainModelBook(){
        return new Book(id, isbn, title, author, total, available);
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
