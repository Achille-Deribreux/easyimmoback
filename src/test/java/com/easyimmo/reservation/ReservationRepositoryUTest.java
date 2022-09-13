package com.easyimmo.reservation;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.easyimmo.EntityBuilder;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.incomes.repository.IncomeRepository;
import com.easyimmo.property.model.Property;
import com.easyimmo.property.repository.PropertyRepository;
import com.easyimmo.reservation.dto.ReservationCriteria;
import com.easyimmo.reservation.model.Reservation;
import com.easyimmo.reservation.repository.ReservationRepository;

@DataJpaTest
class ReservationRepositoryUTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    Property property1;
    Property property2;
    Reservation reservation1;
    Reservation reservation2;
    Income income1;
    Income income2;

    @BeforeEach
    void setUp() {
        property1 = EntityBuilder.buildProperty("first property");
        property1 = propertyRepository.save(property1);
        income1 = EntityBuilder.buildIncome(100, property1);
        income1 = incomeRepository.save(income1);
        reservation1 = EntityBuilder.buildReservation(property1, income1, LocalDate.now().minusDays(1), LocalDate.now().plusDays(1), LocalDate.now().plusDays(10));
        reservation1 = reservationRepository.save(reservation1);

        property2 = EntityBuilder.buildProperty("second property");
        property2 = propertyRepository.save(property2);
        income2 = EntityBuilder.buildIncome(200, property2);
        income2 = incomeRepository.save(income2);
        reservation2 = EntityBuilder.buildReservation(property2, income2, LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(1), LocalDate.now().plusMonths(10));
        reservation2 = reservationRepository.save(reservation2);
    }

    /**
     * TEST CASE 1, we search by property id
     */
    @Test
    void findReservationByMultipleCriteriaTestCase1() {
        //Given
        ReservationCriteria reservationCriteria = new ReservationCriteria().property(property1);
        List<Reservation> expected = Collections.singletonList(reservation1);
        //When
        List<Reservation> result = reservationRepository.findReservationByMultipleCriteria(reservationCriteria);
        //Then
        Assertions.assertEquals(expected, result);
    }

    /**
     * TEST CASE 2, we search by reservationDate
     */
    @Test
    void findReservationByMultipleCriteriaTestCase2() {
        //Given
        ReservationCriteria reservationCriteria = new ReservationCriteria().reservationDate(LocalDate.now().minusDays(1));
        List<Reservation> expected = Collections.singletonList(reservation1);
        //When
        List<Reservation> result = reservationRepository.findReservationByMultipleCriteria(reservationCriteria);
        //Then
        Assertions.assertEquals(expected, result);
    }

    /**
     * TEST CASE 3, we search by fromDate
     */
    @Test
    void findReservationByMultipleCriteriaTestCase3() {
        //Given
        ReservationCriteria reservationCriteria = new ReservationCriteria().fromDate(LocalDate.now().plusDays(1));
        List<Reservation> expected = Collections.singletonList(reservation1);
        //When
        List<Reservation> result = reservationRepository.findReservationByMultipleCriteria(reservationCriteria);
        //Then
        Assertions.assertEquals(expected, result);
    }

    /**
     * TEST CASE 4, we search by toDate
     */
    @Test
    void findReservationByMultipleCriteriaTestCase4() {
        //Given
        ReservationCriteria reservationCriteria = new ReservationCriteria().toDate(LocalDate.now().plusDays(10));
        List<Reservation> expected = Collections.singletonList(reservation1);
        //When
        List<Reservation> result = reservationRepository.findReservationByMultipleCriteria(reservationCriteria);
        //Then
        Assertions.assertEquals(expected, result);
    }

    /**
     * TEST CASE 5, we search wih pageSize and pageNumber
     */
    @Test
    void findReservationByMultipleCriteriaTestCase5() {
        //Given
        ReservationCriteria reservationCriteria = new ReservationCriteria().pageSize(1).pageNumber(1);
        List<Reservation> expected = Collections.singletonList(reservation2);
        //When
        List<Reservation> result = reservationRepository.findReservationByMultipleCriteria(reservationCriteria);
        //Then
        Assertions.assertEquals(expected, result);
    }
}
