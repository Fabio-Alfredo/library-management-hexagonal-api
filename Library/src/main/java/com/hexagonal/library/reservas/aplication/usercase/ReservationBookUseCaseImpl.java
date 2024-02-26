package com.hexagonal.library.reservas.aplication.usercase;

import com.hexagonal.library.reservas.domain.models.Reservation;
import com.hexagonal.library.reservas.domain.ports.in.ReservationBookUseCase;
import com.hexagonal.library.reservas.domain.ports.out.ReservationRepositoryPort;
import org.springframework.http.ResponseEntity;

public class ReservationBookUseCaseImpl implements ReservationBookUseCase {

    private final ReservationRepositoryPort reservationRepositoryPort;

    public ReservationBookUseCaseImpl(ReservationRepositoryPort reservationRepositoryPort) {
        this.reservationRepositoryPort = reservationRepositoryPort;
    }

    @Override
    public ResponseEntity<Object> createReservation(Reservation reservation) {
        return reservationRepositoryPort.save(reservation);
    }
}
