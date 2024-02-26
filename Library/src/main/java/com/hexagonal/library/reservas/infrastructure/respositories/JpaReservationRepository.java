package com.hexagonal.library.reservas.infrastructure.respositories;

import com.hexagonal.library.reservas.infrastructure.entities.ReservationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JpaReservationRepository extends MongoRepository<ReservationEntity, Long> {

}
