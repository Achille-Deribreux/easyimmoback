package com.easyimmo.reservation.repository;

import com.easyimmo.reservation.dto.ReservationCriteria;
import com.easyimmo.reservation.model.Reservation;

import java.util.List;

public interface CustomReservationRepository {

    List<Reservation> findReservationByMultipleCriteria(ReservationCriteria reservationCriteria);
}
