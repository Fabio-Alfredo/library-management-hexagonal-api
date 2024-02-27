package com.hexagonal.library.reservas.domain.models;

import java.util.List;

public class Reservation {
    private String id;
    private String userName;
    private List<String> booksTitle;

    public Reservation(String id, String userName, List<String> booksTitle) {
        this.id = id;
        this.userName = userName;
        this.booksTitle = booksTitle;
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

    public List<String> getBooksTitle() {
        return booksTitle;
    }

    public void setBooksTitle(List<String> booksTitle) {
        this.booksTitle = booksTitle;
    }
}
