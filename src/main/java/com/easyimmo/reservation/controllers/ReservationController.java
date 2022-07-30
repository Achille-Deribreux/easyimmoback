package com.easyimmo.reservation.controllers;

import com.easyimmo.common.utils.Converter;
import com.easyimmo.reservation.dto.ReservationBody;
import com.easyimmo.reservation.dto.ReservationCriteria;
import com.easyimmo.reservation.dto.ReservationDetails;
import com.easyimmo.reservation.dto.ReservationSummary;
import com.easyimmo.reservation.model.Reservation;
import com.easyimmo.reservation.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    private final Converter converter;

    public ReservationController(ReservationService reservationService, Converter converter) {
        this.reservationService = reservationService;
        this.converter = converter;
    }

    private final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    /**
     * This method answer to a request at : /reservation/getById and returns a response entity with the wanted reservation
     * @param id id of the wanted reservation
     * @return response entity with the wanted reservation and status code 200 if everything is ok
     */
    @RequestMapping(value="/getById")
    public ResponseEntity<ReservationDetails> getReservationById(@RequestParam(value="id") Integer id) {
        logger.info("get request received at reservation/getById for id : {}", id);
        return new ResponseEntity<>(converter.convertToReservationDetails(reservationService.getById(id)), HttpStatus.OK);
    }

    /**
     * This method answer to a request at : /reservation/getAll and returns a response entity with the all the reservations
     * @return a list of all the reservations and status code 200 if everything is ok
     */
    @RequestMapping(value="/getAll")
    public ResponseEntity<List<ReservationSummary>> getAllReservations(
            @RequestParam(value = "propertyId",required=false)Integer propertyId,
            @RequestParam(value = "fromDate",required=false) LocalDate fromDate,
            @RequestParam(value = "toDate",required=false)LocalDate toDate,
            @RequestParam(value = "reservationDate",required=false)LocalDate reservationDate,
            @RequestParam(value="pageNr",required=false)Integer pageNr,
            @RequestParam(value="pageSize",required=false)Integer pageSize
    ) {
        logger.info("get request received at reservation/getAll");
        ReservationCriteria criteria = new ReservationCriteria()
                .propertyId(propertyId)
                .fromDate(fromDate)
                .toDate(toDate)
                .reservationDate(reservationDate)
                .pageNumber(pageNr)
                .pageSize(pageSize);
        List<Reservation> reservationsList = reservationService.getAll(criteria);
        return new ResponseEntity<>(converter.convertListToReservationSummary(reservationsList), HttpStatus.OK);
    }

    /**
     * This method answer to a request at : /reservation/create and returns a response entity with the created reservation
     * @param reservationBody reservation to create
     * @return response entity with the created reservation and status code 200 if everything is ok
     */
    @RequestMapping(value="/add")
    public ResponseEntity<ReservationDetails> addReservation(@RequestBody ReservationBody reservationBody) {
        logger.info("post request received at reservation/add for reservationBody : {}", reservationBody);
        return new ResponseEntity<>(converter.convertToReservationDetails(reservationService.addReservation(converter.convertToReservationBody(reservationBody))), HttpStatus.OK);
    }

    /**
     * This method answer to a request at : /reservation/update and returns a response entity with the updated reservation
     * @param id id of the reservation to update
     * @param reservationBody reservation to update
     * @return response entity with the updated reservation and status code 200 if everything is ok
     */
    @RequestMapping(value="/update")
    public ResponseEntity<ReservationDetails> updateReservation(@RequestParam(value="id") Integer id, @RequestBody ReservationBody reservationBody) {
        logger.info("put request received at reservation/update for id : {} and reservationBody : {}", id, reservationBody);
        return new ResponseEntity<>(converter.convertToReservationDetails(reservationService.updateReservation(id, converter.convertToReservationBody(reservationBody))), HttpStatus.OK);
    }

    /**
     * This method answer to a request at : /reservation/delete and returns a response entity with the deleted reservation
     * @param id id of the reservation to delete
     * @return response entity with the deleted reservation and status code 200 if everything is ok
     */
    @RequestMapping(value="/delete")
    public ResponseEntity<String> deleteReservation(@RequestParam(value="id") Integer id) {
        logger.info("delete request received at reservation/delete for id : {}", id);
        reservationService.deleteById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
