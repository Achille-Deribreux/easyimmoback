package com.easyimmo;

import java.time.LocalDate;
import java.util.Collections;

import com.easyimmo.fees.model.Fee;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.property.model.Property;
import com.easyimmo.reservation.model.Reservation;

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

    public static Reservation buildDefaultReservation(Property property, Income income) {
        return new Reservation()
                .property(property)
                .reservationDate(LocalDate.now().minusMonths(1))
                .fromDate(LocalDate.now().plusWeeks(1))
                .toDate(LocalDate.now().plusWeeks(3))
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
                .incomeType(Income.IncomeType.SHORTRENT)
                .amount(amount)
                .date(LocalDate.now())
                .description("description")
                .property(property);
    }

    public static Fee buildFee(){
        return new Fee()
                .amount(1000)
                .description("description")
                .supplier("supplier")
                .property(buildProperty("property"))
                .date(LocalDate.now());
    }
}
