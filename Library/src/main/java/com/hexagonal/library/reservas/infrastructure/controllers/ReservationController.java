package com.hexagonal.library.reservas.infrastructure.controllers;

import com.hexagonal.library.reservas.aplication.service.ReservationService;
import com.hexagonal.library.reservas.domain.models.Reservation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Object>createdReservation(@RequestBody Reservation reservation){
       return reservationService.createReservation(reservation);
    }
}
