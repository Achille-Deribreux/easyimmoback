package com.easyimmo.reservation.repository;

import java.util.List;

import com.easyimmo.reservation.dto.ReservationCriteria;
import com.easyimmo.reservation.model.Reservation;

public interface CustomReservationRepository {

    List<Reservation> findReservationByMultipleCriteria(ReservationCriteria reservationCriteria);
}
