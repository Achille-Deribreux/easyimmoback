package com.easyimmo.reservation.service;

import com.easyimmo.reservation.model.Reservation;

import java.util.List;

public interface IReservationService {

    /**
     * This method search for a reservation, based on a given id
     * @param id id of the reservation that you search
     * @return the wanted reservation
     */
    Reservation getById(Integer id);

    /**
     * This method search for all the properties
     * @return list of all the properties
     */
    List<Reservation> getAll();

    /**
     * This method allows you to update a reservation
     * @param reservation updated reservation
     * @return updated reservation
     */
    Reservation updateReservation(Integer id, Reservation reservation);

    /**
     * This method allows you to add a reservation
     * @param reservation reservation that you want to add
     * @return the added reservation
     */
    Reservation addReservation(Reservation reservation);

    /**
     * This method allows you to delete a reservation, for a given id
     * @param id of the reservation that you want to delete
     */
    void deleteById(Integer id);
}
