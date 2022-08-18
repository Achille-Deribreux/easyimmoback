package com.easyimmo.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easyimmo.reservation.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer>,CustomReservationRepository {
}
