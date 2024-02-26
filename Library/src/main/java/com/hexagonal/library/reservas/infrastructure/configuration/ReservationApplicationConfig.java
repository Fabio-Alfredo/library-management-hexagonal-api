package com.hexagonal.library.reservas.infrastructure.configuration;

import com.hexagonal.library.reservas.aplication.service.ReservationService;
import com.hexagonal.library.reservas.aplication.usercase.ReservationBookUseCaseImpl;
import com.hexagonal.library.reservas.domain.ports.out.ReservationRepositoryPort;
import com.hexagonal.library.reservas.infrastructure.adapters.JpaReservationRepositoryAdapter;
import com.hexagonal.library.reservas.infrastructure.respositories.JpaReservationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationApplicationConfig {
    @Bean
    public ReservationService reservationService(ReservationRepositoryPort reservationRepositoryPort){
        return new ReservationService(
                new ReservationBookUseCaseImpl(reservationRepositoryPort)
        );
    }

    @Bean
    public ReservationRepositoryPort reservationRepositoryPort(JpaReservationRepositoryAdapter jpaReservationRepositoryAdapter){
        return jpaReservationRepositoryAdapter;
    }
}
