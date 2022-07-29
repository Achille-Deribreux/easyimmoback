package com.easyimmo.common.utils;

import com.easyimmo.bankloan.dto.BankLoanSummary;
import com.easyimmo.fees.dto.FeeDto;
import com.easyimmo.fees.dto.FeeSummary;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.fees.service.FeeService;
import com.easyimmo.incomes.dto.IncomeDto;
import com.easyimmo.incomes.dto.IncomeSummary;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.incomes.service.IncomeService;
import com.easyimmo.property.dto.PropertyDetails;
import com.easyimmo.property.dto.PropertyDto;
import com.easyimmo.property.dto.PropertySummary;
import com.easyimmo.property.model.Property;
import com.easyimmo.property.service.PropertyService;
import com.easyimmo.reservation.dto.ReservationBody;
import com.easyimmo.reservation.dto.ReservationDetails;
import com.easyimmo.reservation.dto.ReservationSummary;
import com.easyimmo.reservation.model.Reservation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    private PropertyService propertyService;

    private FeeService feeService;

    private IncomeService incomeService;


    public Converter(PropertyService propertyService, FeeService feeService, IncomeService incomeService) {
        this.propertyService = propertyService;
        this.feeService = feeService;
        this.incomeService = incomeService;
    }

    public Fee convert(FeeDto feeDto){
        return new Fee(
                feeDto.getId(),
                propertyService.getById(feeDto.getPropertyId()),
                feeDto.getSupplier(),
                feeDto.getDescription(),
                feeDto.getAmount(),
                feeDto.getDate()
        );
    }

    public FeeDto convert(Fee fee){
        return new FeeDto(
                fee.getId(),
                fee.getProperty().getId(),
                fee.getSupplier(),
                fee.getDescription(),
                fee.getAmount(),
                fee.getDate()
        );
    }

     public Property convert(PropertyDto propertyDto){
        return new Property(
                propertyDto.getId(),
                propertyDto.getAddress(),
                propertyDto.getName(),
                propertyDto.getType(),
                propertyDto.getRentType(),
                propertyDto.getPrixAchat()
        );
    }

     public PropertyDto convert(Property property){
        return new PropertyDto(
                property.getId(),
                property.getAddress(),
                property.getName(),
                property.getType(),
                property.getRentType(),
                property.getBuyPrice()
        );
    }

    public PropertySummary convertToSummary(Property property){
        return new PropertySummary()
                .id(property.getId())
                .address(property.getAddress())
                .name(property.getName())
                .type(property.getType());
    }

    public PropertyDetails convertToDetails (Property property){
        return new PropertyDetails()
                .id(property.getId())
                .address(property.getAddress())
                .name(property.getName())
                .type(property.getType().toString())
                .rentType(property.getRentType().toString())
                .buyPrice(property.getBuyPrice())
                .bankLoanSummary(new BankLoanSummary())
                .yearlyFees(1)
                .yearlyIncomes(1)
                .monthlyFees(1)
                .monthlyIncomes(1)
                .fees(List.of(new FeeSummary()))
                .incomes(List.of(new IncomeSummary()))
                .reservations(List.of(new ReservationSummary()));
    }

    public IncomeDto convert(Income income){
        return new IncomeDto(
                income.getId(),
                income.getProperty().getId(),
                income.getDescription(),
                income.getAmount(),
                income.getDate()
                );
    }

    public Income convert(IncomeDto incomeDto){
        return new Income(
                incomeDto.getId(),
                propertyService.getById(incomeDto.getPropertyId()),
                incomeDto.getAmount(),
                incomeDto.getDescription(),
                incomeDto.getDate(),
                null
        );
    }

    public List<PropertySummary>convertPropertyList(List<Property> propertyList){
        return propertyList.stream().map(this::convertToSummary).collect(Collectors.toList());
    }

    public List<FeeDto> convertFeeList(List<Fee> feeList){
        return feeList.stream().map(this::convert).collect(Collectors.toList());
    }

    public List<IncomeDto> convertIncomeList(List<Income> incomeList){
        return incomeList.stream().map(this::convert).collect(Collectors.toList());
    }

    public ReservationDetails convertToReservationDetails(Reservation reservation){
        return new ReservationDetails()
                .id(reservation.getId())
                .reservationDate(reservation.getReservationDate())
                .fromDate(reservation.getFromDate())
                .toDate(reservation.getToDate())
                .property(convert(reservation.getProperty()))
                .income(convert(reservation.getIncome()))
                .feeList(convertFeeList(reservation.getFeeList()));
    }

    public ReservationSummary convertToReservationSummary(Reservation reservation){
        return new ReservationSummary()
                .id(reservation.getId())
                .fromDate(reservation.getFromDate())
                .toDate(reservation.getToDate())
                .propertyName(reservation.getProperty().getName());
    }

    public Reservation convert(ReservationBody reservationBody){
        List<Fee> feeList = null;
        if(reservationBody.getFeeIdList()!=null && !reservationBody.getFeeIdList().isEmpty()){
            feeList = reservationBody.getFeeIdList().stream().map(id -> feeService.getFeeById(id)).collect(Collectors.toList());
        }
        return new Reservation()
                .id(reservationBody.getId())
                .reservationDate(reservationBody.getReservationDate())
                .fromDate(reservationBody.getFromDate())
                .toDate(reservationBody.getToDate())
                .property(propertyService.getById(reservationBody.getPropertyId()))
                .income(incomeService.getIncomeById(reservationBody.getIncomeId()))
                .feeList(feeList);
    }

    public List<ReservationSummary> convertListToReservationSummary(List<Reservation> reservationList){
        return reservationList.stream().map(this::convertToReservationSummary).collect(Collectors.toList());
    }
}
