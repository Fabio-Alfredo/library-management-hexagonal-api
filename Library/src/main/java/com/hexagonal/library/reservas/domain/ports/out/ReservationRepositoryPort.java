package com.hexagonal.library.reservas.domain.ports.out;

import com.hexagonal.library.reservas.domain.models.Reservation;
import org.springframework.http.ResponseEntity;

public interface ReservationRepositoryPort {

    ResponseEntity<Object>save(Reservation reservation);
}
