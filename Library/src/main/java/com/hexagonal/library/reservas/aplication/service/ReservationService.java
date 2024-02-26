package com.hexagonal.library.reservas.aplication.service;

import com.hexagonal.library.reservas.domain.models.Reservation;
import com.hexagonal.library.reservas.domain.ports.in.ReservationBookUseCase;
import org.springframework.http.ResponseEntity;

public class ReservationService implements ReservationBookUseCase {

    private final ReservationBookUseCase reservationBookUseCase;

    public ReservationService(ReservationBookUseCase reservationBookUseCase) {
        this.reservationBookUseCase = reservationBookUseCase;
    }

    @Override
    public ResponseEntity<Object> createReservation(Reservation reservation) {
        return reservationBookUseCase.createReservation(reservation);
    }
}
