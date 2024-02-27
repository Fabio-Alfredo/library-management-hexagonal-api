package com.hexagonal.library.reservas.infrastructure.entities;

import com.hexagonal.library.reservas.domain.models.Reservation;
import jakarta.persistence.Id;

import java.util.List;

public class ReservationEntity {
    @Id
    private String id;
    private String userName;
    private List<String> booksTitle;

    public ReservationEntity() {

    }

    public ReservationEntity(String id, String userName, List<String> booksTitle) {
        this.id = id;
        this.userName = userName;
        this.booksTitle = booksTitle;
    }

    public static ReservationEntity fromDomainModel(Reservation reservation){
        return new ReservationEntity(reservation.getId(), reservation.getUserName(), reservation.getBooksTitle());
    }

    public Reservation toDomainModel(){
        return new Reservation(id, userName, booksTitle);
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
