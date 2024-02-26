package com.hexagonal.library.reservas.domain.ports.in;

import com.hexagonal.library.reservas.domain.models.Reservation;
import org.springframework.http.ResponseEntity;

public interface ReservationBookUseCase {
    ResponseEntity<Object>createReservation(Reservation reservation);
}
