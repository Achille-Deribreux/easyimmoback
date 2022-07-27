package com.easyimmo.reservation.repository;

import com.easyimmo.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer>,CustomReservationRepository {
}
