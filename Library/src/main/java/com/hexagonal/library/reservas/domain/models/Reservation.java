package com.hexagonal.library.reservas.domain.models;

public class Reservation {
    private String id;
    private String userName;
    private String bookName;

    public Reservation(String id, String userName, String bookName) {
        this.id = id;
        this.userName = userName;
        this.bookName = bookName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
