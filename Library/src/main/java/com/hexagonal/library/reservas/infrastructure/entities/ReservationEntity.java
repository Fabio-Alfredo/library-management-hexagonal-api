package com.hexagonal.library.reservas.infrastructure.entities;

import com.hexagonal.library.reservas.domain.models.Reservation;
import jakarta.persistence.Id;

public class ReservationEntity {
    @Id
    private String id;
    private String userName;
    private String bookName;

    public ReservationEntity(String id, String userName, String bookName) {
        this.id = id;
        this.userName = userName;
        this.bookName = bookName;
    }

    public static ReservationEntity fromDomainModel(Reservation reservation){
        return new ReservationEntity(reservation.getId(), reservation.getUserName(), reservation.getBookName());
    }

    public Reservation toDomainModel(){
        return new Reservation(id, userName, bookName);
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
