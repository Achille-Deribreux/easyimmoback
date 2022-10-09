package com.easyimmo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.easyimmo.bankloan.dto.BankLoanSummary;
import com.easyimmo.bankloan.dto.BankloanBody;
import com.easyimmo.bankloan.dto.BankloanDetails;
import com.easyimmo.bankloan.model.Bankloan;
import com.easyimmo.fees.dto.FeeDetails;
import com.easyimmo.fees.dto.FeeDto;
import com.easyimmo.fees.dto.FeeSummary;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.incomes.dto.IncomeBody;
import com.easyimmo.incomes.dto.IncomeDetails;
import com.easyimmo.incomes.dto.IncomeSummary;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.property.dto.PropertyDetails;
import com.easyimmo.property.dto.PropertyDto;
import com.easyimmo.property.dto.PropertySummary;
import com.easyimmo.property.model.Property;
import com.easyimmo.reservation.dto.ReservationBody;
import com.easyimmo.reservation.dto.ReservationDetails;
import com.easyimmo.reservation.dto.ReservationSummary;
import com.easyimmo.reservation.model.Reservation;

public class DemoTestData {

    private DemoTestData() {
    }

    /**
     * FEE DATA
     */
    public static FeeDto getFeeDto(){
        return new FeeDto()
                .id(1)
                .propertyId(1)
                .description("description")
                .supplier("supplier")
                .amount(100)
                .date(LocalDate.now());
    }

    public static Fee getFee(){
        return new Fee()
            .id(1)
            .property(getProperty())
            .description("description")
            .supplier("supplier")
            .amount(100)
            .date(LocalDate.now());
    }

    public static FeeDetails getFeeDetails(){
        return new FeeDetails()
                .id(1)
                .property(getProperty())
                .description("description")
                .supplier("supplier")
                .amount(100)
                .date(LocalDate.now());
    }

    public static FeeSummary getFeeSummary(){
        return new FeeSummary()
                .id(1)
                .supplier("supplier")
                .amount(100)
                .date(LocalDate.now());
    }

    /**
     * PROPERTY DATA
     */

    public static Property getProperty(){
        return new Property()
                .id(1)
                .address("75 test street belgium")
                .name("test property name")
                .type(Property.Type.APPARTMENT)
                .rentType(Property.RentType.LONG)
                .buyPrice(120000)
                .userId(1);
    }

    public static PropertyDto getPropertyDto(){
        return new PropertyDto()
                .id(1)
                .address("75 test street belgium")
                .name("test property name")
                .type(Property.Type.APPARTMENT)
                .rentType(Property.RentType.LONG)
                .prixAchat(120000)
                .userId(1);
    }

    public static PropertySummary getPropertySummary(){
        return new PropertySummary()
                .id(1)
                .address("75 test street belgium")
                .name("test property name")
                .type(Property.Type.APPARTMENT);
    }

    public static PropertyDetails getPropertyDetails(){
        return new PropertyDetails()
                .id(1)
                .address("75 test street belgium")
                .name("test property name")
                .type("APPARTMENT")
                .rentType("LONG")
                .buyPrice(120000)
                .bankLoanSummary(getBankLoanSummary())
                .yearlyFees(1200)
                .yearlyIncomes(10000)
                .monthlyFees(120)
                .monthlyIncomes(800)
                .fees(Collections.singletonList(getFeeSummary()))
                .incomes(Collections.singletonList(getIncomeSummary()))
                .reservations(Collections.singletonList(getReservationSummary()));
    }

    /**
     * INCOME DATA
     */

    public static Income getIncome(){
        return new Income()
                .id(1)
                .property(getProperty())
                .amount(100)
                .description("description")
                .incomeType(Income.IncomeType.SHORTRENT)
                .date(LocalDate.now());
    }

    public static IncomeSummary getIncomeSummary(){
        return new IncomeSummary()
                .id(1)
                .amount(100)
                .description("description")
                .date(LocalDate.now());
    }

    public static IncomeDetails getIncomeDetails(){
        return new IncomeDetails()
                .id(1)
                .property(getPropertySummary())
                .amount(100)
                .incomeType(Income.IncomeType.SHORTRENT)
                .description("description")
                .date(LocalDate.now());
    }

    public static IncomeBody getIncomeBody(){
        return new IncomeBody()
                .id(1)
                .propertyId(1)
                .amount(100)
                .incomeType(Income.IncomeType.SHORTRENT)
                .description("description")
                .date(LocalDate.now());
    }

    /**
     * RESERVATION DATA
     */

    public static Reservation getReservation() {
        return new Reservation()
                .id(1)
                .property(getProperty())
                .reservationDate(LocalDate.now())
                .fromDate(LocalDate.now().plusWeeks(1))
                .toDate(LocalDate.now().plusWeeks(2))
                .income(getIncome())
                .feeList(List.of(getFee()));
    }

    public static ReservationSummary getReservationSummary() {
        return new ReservationSummary()
                .id(1)
                .propertyName(getPropertySummary().getName())
                .fromDate(LocalDate.now().plusWeeks(1))
                .toDate(LocalDate.now().plusWeeks(2))
                .price(getIncome().getAmount());
    }

    public static ReservationDetails getReservationDetails() {
        return new ReservationDetails()
                .id(1)
                .property(getPropertyDto())
                .reservationDate(LocalDate.now())
                .fromDate(LocalDate.now().plusWeeks(1))
                .toDate(LocalDate.now().plusWeeks(2))
                .income(getIncomeSummary())
                .feeList(List.of(getFeeDto()));
    }

    public static ReservationBody getReservationBody() {
        return new ReservationBody()
                .id(1)
                .propertyId(1)
                .fromDate(LocalDate.now().plusWeeks(1))
                .toDate(LocalDate.now().plusWeeks(2))
                .reservationDate(LocalDate.now())
                .amount(getIncome().getAmount());
    }

    /**
     * BANKLOAN DATA
     */

    public static Bankloan getBankLoan() {
        return new Bankloan()
                .id(1)
                .property(getProperty())
                .totalAmount(10000000L)
                .monthlyPayment(41667L)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusYears(20));
    }

    public static BankloanDetails getBankLoanDetails() {
        return new BankloanDetails()
                .id(1)
                .totalAmount(10000000L)
                .monthlyPayment(41667L)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusYears(20));
    }

    public static BankloanBody getBankLoanBody() {
        return new BankloanBody()
                .id(1)
                .propertyId(1)
                .totalAmount(10000000L)
                .monthlyPayment(41667L)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusYears(20));
    }

    public static BankLoanSummary getBankLoanSummary(){
        return new BankLoanSummary()
                .totalAmount(10000000L)
                .dueAmount(4000000L)
                .refundedAmount(6000000L);

    }
}