package com.easyimmo;

import com.easyimmo.incomes.model.Income;
import com.easyimmo.property.model.Property;
import com.easyimmo.reservation.model.Reservation;

import java.time.LocalDate;
import java.util.Collections;

public class EntityBuilder {

    public static Reservation buildReservation(Property property, Income income, LocalDate reservationDate, LocalDate fromDate, LocalDate toDate) {
        return new Reservation()
                .property(property)
                .reservationDate(reservationDate)
                .fromDate(fromDate)
                .toDate(toDate)
                .income(income)
                .feeList(Collections.emptyList());
    }

    public static Property buildProperty(String name){
        return new Property()
                .name(name)
                .address("address")
                .type(Property.Type.HOUSE)
                .rentType(Property.RentType.LONG)
                .buyPrice(10000);
    }

    public static Income buildIncome(Integer amount, Property property){
        return new Income()
                .amount(amount)
                .date(LocalDate.now())
                .description("description")
                .property(property);
    }
}
