package com.easyimmo.reservation.service;

import com.easyimmo.common.exception.ReservationNotFoundException;
import com.easyimmo.property.service.PropertyService;
import com.easyimmo.reservation.dto.ReservationCriteria;
import com.easyimmo.reservation.dto.UpdateReservationHelper;
import com.easyimmo.reservation.model.Reservation;
import com.easyimmo.reservation.repository.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservationService {

    private final Logger logger = LoggerFactory.getLogger(ReservationService.class);

    private final ReservationRepository reservationRepository;

    private final PropertyService propertyService;

    public ReservationService(ReservationRepository reservationRepository, PropertyService propertyService) {
        this.reservationRepository = reservationRepository;
        this.propertyService = propertyService;
    }

    @Override
    public Reservation getById(Integer id) {
        logger.info("search in repository {}",id);
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("id" +id));
    }

    @Override
    public List<Reservation> getAll(ReservationCriteria criteria) {
        logger.info("get all from repository with criteria {}",criteria);
        return reservationRepository.findReservationByMultipleCriteria(criteria);
    }

    @Override
    public Reservation updateReservation(Integer id, Reservation reservationBody) {
        logger.info("update reservation for reservation id : {}", reservationBody);
        Reservation originalReservation = getById(id);
        UpdateReservationHelper updateReservationHelper = UpdateReservationHelper.of(originalReservation);
        Reservation updatedReservation = updateReservationHelper.build(reservationBody);
        return reservationRepository.save(updatedReservation);
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        logger.info("add reservation");
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteById(Integer id) {
        logger.info("delete reservation for id : {}", id);
        Reservation reservationToDelete = getById(id);
        reservationRepository.delete(reservationToDelete);
    }

    @Override
    public List<Reservation> getLastReservations(Integer propertyId, Integer nbReservations) {
        ReservationCriteria reservationCriteria = new ReservationCriteria().property(propertyService.getById(propertyId)).pageSize(nbReservations).pageNumber(1);
        return reservationRepository.findReservationByMultipleCriteria(reservationCriteria);
    }
}
