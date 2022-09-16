package com.easyimmo.reservation;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

import com.easyimmo.AuthenticationMock;
import com.easyimmo.EntityBuilder;
import com.easyimmo.common.exception.ReservationNotFoundException;
import com.easyimmo.common.utils.CustomValidator;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.incomes.service.IncomeService;
import com.easyimmo.property.model.Property;
import com.easyimmo.property.service.PropertyService;
import com.easyimmo.reservation.dto.ReservationCriteria;
import com.easyimmo.reservation.model.Reservation;
import com.easyimmo.reservation.repository.ReservationRepository;
import com.easyimmo.reservation.service.ReservationService;
import com.easyimmo.user.service.UserService;

@SpringBootTest
class ReservationServiceUTest {

    @Mock
    CustomValidator validator;

    @Mock
    ReservationRepository reservationRepository;

    @Mock
    IncomeService  incomeService;

    @Mock
    PropertyService propertyService;

    @Mock
    UserService userService;

    @InjectMocks
    ReservationService reservationService;

    @BeforeEach
    void setUp() {
        SecurityContext securityContext = new SecurityContextImpl();
        securityContext.setAuthentication(AuthenticationMock.getAuthenticationMock());
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    void getByIdTest() {
        //Given
        Integer id = 1;
        //When
        Mockito.when(reservationRepository.findById(id)).thenReturn(Optional.of(new Reservation().property(new Property().userId(1))));
        reservationService.getById(id);
        //Then
        Mockito.verify(reservationRepository,Mockito.times(1)).findById(id);
    }

    @Test
    void getByIdExceptionTest() {
        //Given
        Integer id = 1;
        //When & Then
        Assertions.assertThrows(ReservationNotFoundException.class,()->reservationService.getById(id));
    }

    @Test
    void getAllTest() {
        //Given
        ReservationCriteria reservationCriteria = new ReservationCriteria().pageNumber(1).pageSize(10);
        //When
        Mockito.when(userService.getUserId("test")).thenReturn(1);
        reservationService.getAll(reservationCriteria);
        //Then
        Mockito.verify(reservationRepository,Mockito.times(1)).findReservationByMultipleCriteria(reservationCriteria);
    }

    @Test
    void deleteByIdTest() {
        //Given
        Reservation reservation = new Reservation().id(1).property(new Property().userId(1));
        //When
        Mockito.when(userService.getUserId("test")).thenReturn(1);
        Mockito.when(reservationRepository.findById(reservation.getId())).thenReturn(Optional.of(reservation));
        reservationService.deleteById(reservation.getId());
        //Then
        Mockito.verify(reservationRepository,Mockito.times(1)).delete(reservation);
    }

    @Test
    void getLastReservationsTest() {
        //Given
        Integer propertyId = 34;
        Property property = new Property().id(propertyId).address("address").type(Property.Type.APPARTMENT).rentType(Property.RentType.LONG);
        Integer nbReservations = 3;
        //When
        Mockito.when(userService.getUserId("test")).thenReturn(1);
        Mockito.when(propertyService.getById(propertyId)).thenReturn(property);
        reservationService.getLastReservations(propertyId,nbReservations);
        //Then
        Mockito.verify(reservationRepository,Mockito.times(1)).findReservationByMultipleCriteria(new ReservationCriteria().property(property).pageSize(nbReservations).pageNumber(1));
    }

    @Test
    void updateReservationTest() {
        //Given
        Property property = EntityBuilder.buildProperty("test").id(12312);
        Income income = EntityBuilder.buildIncome(1234567,property);
        Reservation reservation = EntityBuilder.buildDefaultReservation(property,income).id(1);
        Reservation reservationBody = new Reservation().fromDate(LocalDate.MAX).toDate(LocalDate.MAX).reservationDate(LocalDate.MAX);
        Reservation updatedReservation = reservation.fromDate(LocalDate.MAX).toDate(LocalDate.MAX).reservationDate(LocalDate.MAX);

        //When
        Mockito.when(userService.getUserId("test")).thenReturn(1);
        Mockito.when(reservationRepository.findById(reservation.getId())).thenReturn(Optional.of(reservation));
        reservationService.updateReservation(reservation.getId(),reservationBody,9999);
        //Then
        Mockito.verify(reservationRepository,Mockito.times(1)).save(updatedReservation);
    }

    @Test
    void addReservationTest() {
        //Given
        Property property = EntityBuilder.buildProperty("test").id(12312);
        Income income = EntityBuilder.buildIncome(1234567,property);
        Reservation reservation = EntityBuilder.buildDefaultReservation(property,income);
        //When
        Mockito.when(propertyService.getById(property.getId())).thenReturn(property);
        Mockito.when(incomeService.getIncomeById(income.getId())).thenReturn(income);
        reservationService.addReservation(reservation,9999);
        //Then
        Mockito.verify(reservationRepository,Mockito.times(1)).save(reservation);
    }
}
