package com.easyimmo.reservation.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.easyimmo.common.exception.ReservationNotFoundException;
import com.easyimmo.common.utils.CustomValidator;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.incomes.service.IncomeService;
import com.easyimmo.property.service.PropertyService;
import com.easyimmo.reservation.dto.ReservationCriteria;
import com.easyimmo.reservation.dto.UpdateReservationHelper;
import com.easyimmo.reservation.model.Reservation;
import com.easyimmo.reservation.repository.ReservationRepository;

@Service
public class ReservationService implements IReservationService {

    private final Logger logger = LoggerFactory.getLogger(ReservationService.class);

    private final ReservationRepository reservationRepository;

    private final PropertyService propertyService;

    private final IncomeService incomeService;

    private final CustomValidator validator;

    public ReservationService(ReservationRepository reservationRepository, PropertyService propertyService, IncomeService incomeService, CustomValidator validator) {
        this.reservationRepository = reservationRepository;
        this.propertyService = propertyService;
        this.incomeService = incomeService;
        this.validator = validator;
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
    public Reservation updateReservation(Integer id, Reservation reservationBody, Integer price) {
        logger.info("update reservation for reservation id : {}", reservationBody);
        Reservation originalReservation = getById(id);
        if(price!=null){
            reservationBody.income(originalReservation.getIncome().amount(price));
        }
        UpdateReservationHelper updateReservationHelper = UpdateReservationHelper.of(originalReservation);
        Reservation updatedReservation = updateReservationHelper.build(reservationBody);
        return reservationRepository.save(updatedReservation);
    }

    @Override
    public Reservation addReservation(  Reservation reservation, Integer price) {
        validator.validate(reservation);
        logger.info("add reservation");
        Income income = new Income()
                .amount(price)
                .property(propertyService.getById(reservation.getProperty().getId()))
                .date(reservation.getFromDate())
                .description("Reservation for property " + reservation.getProperty().getName())
                .incomeType(Income.IncomeType.SHORTRENT);
        income = incomeService.addIncome(income);
        reservation.setIncome(income);
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
