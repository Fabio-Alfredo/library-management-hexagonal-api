package com.hexagonal.library.reservas.infrastructure.adapters;

import com.hexagonal.library.book.infrastructure.adapters.JpaBookRepositoryAdapter;
import com.hexagonal.library.book.infrastructure.entities.BookEntity;
import com.hexagonal.library.book.infrastructure.repositories.JpaBookRepository;
import com.hexagonal.library.exceptions.dto.ExceptionErrorMessage;
import com.hexagonal.library.exceptions.dto.MessageAcceptedService;
import com.hexagonal.library.reservas.domain.models.Reservation;
import com.hexagonal.library.reservas.domain.ports.out.ReservationRepositoryPort;
import com.hexagonal.library.reservas.infrastructure.entities.ReservationEntity;
import com.hexagonal.library.reservas.infrastructure.respositories.JpaReservationRepository;
import com.hexagonal.library.user.infrastructure.entities.UserEntity;
import com.hexagonal.library.user.infrastructure.respositories.JpaUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JpaReservationRepositoryAdapter implements ReservationRepositoryPort {

    private final JpaReservationRepository jpaReservationRepository;
    private final JpaUserRepository jpaUserRepository;
    private final JpaBookRepository jpaBookRepository;

    public JpaReservationRepositoryAdapter(JpaReservationRepository jpaReservationRepository, JpaUserRepository jpaUserRepository, JpaBookRepositoryAdapter jpaBookRepositoryAdapter, JpaBookRepository jpaBookRepository) {
        this.jpaReservationRepository = jpaReservationRepository;
        this.jpaUserRepository = jpaUserRepository;
        this.jpaBookRepository = jpaBookRepository;
    }

    @Override
    public ResponseEntity<Object> save(Reservation reservation) {
        try {
            UserEntity userEntity = jpaUserRepository.findByName(reservation.getUserName());
            List<BookEntity> bookEntities = jpaBookRepository.findByTitleIn(reservation.getBooksTitle());

            if (userEntity == null) {
                return ResponseEntity.badRequest().body(new ExceptionErrorMessage("Usuario no existente"));
            }

            if (bookEntities.isEmpty()) {
                return ResponseEntity.badRequest().body(new ExceptionErrorMessage("Libro no existente"));
            }

            List<String> errorMessages = new ArrayList<>();

            for (BookEntity bookEntity : bookEntities) {
                if (bookEntity.getAvailable() <= 0) {
                    errorMessages.add("Libro no disponible: " + bookEntity.getTitle());
                } else {
                    bookEntity.sumBook(-1, 0);
                }
            }

            if (!errorMessages.isEmpty()) {
                return ResponseEntity.badRequest().body(new ExceptionErrorMessage(String.join(", ", errorMessages)));
            }

            List<String> userBooks = userEntity.getBooks();
            if (userBooks == null) {
                userBooks = new ArrayList<>();
            }

            for (BookEntity bookEntity : bookEntities) {
                userBooks.add(bookEntity.getTitle());
            }

            userEntity.setBooks(userBooks);

            ReservationEntity reservationEntity = ReservationEntity.fromDomainModel(reservation);

            jpaBookRepository.saveAll(bookEntities);
            jpaUserRepository.save(userEntity);
            jpaReservationRepository.save(reservationEntity);

            return ResponseEntity.ok(new MessageAcceptedService("Libros disponibles"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ExceptionErrorMessage("Error interno en el servidor" + e.getMessage()));
        }
    }



}
