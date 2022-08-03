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
import com.easyimmo.reservation.dto.ReservationCriteria;
import com.easyimmo.reservation.dto.ReservationDetails;
import com.easyimmo.reservation.dto.ReservationSummary;
import com.easyimmo.reservation.model.Reservation;
import com.easyimmo.reservation.service.ReservationService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    private PropertyService propertyService;

    private FeeService feeService;

    private IncomeService incomeService;

    private ReservationService reservationService;


    public Converter(PropertyService propertyService, FeeService feeService, IncomeService incomeService , ReservationService reservationService) {
        this.propertyService = propertyService;
        this.feeService = feeService;
        this.incomeService = incomeService;
        this.reservationService = reservationService;
    }

    /**
     * FEES CONVERTERS
     */
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

    public FeeSummary convertToSummary(Fee fee) {
        return new FeeSummary()
                .id(fee.getId())
                .date(fee.getDate())
                .amount(fee.getAmount())
                .supplier(fee.getSupplier());
    }

    public List<FeeDto> convertFeeList(List<Fee> feeList){
        return feeList.stream().map(this::convert).collect(Collectors.toList());
    }

    public List<FeeSummary> convertToFeeSummaryList( List<Fee> fees){
        return fees.stream()
                .map(this::convertToSummary)
                .collect(Collectors.toList());
    }


    /**
     * PROPERTY CONVERTERS
     */

    //EnumMapper
    private static final EnumMapper<String, Property.Type> propertyTypeMap = new EnumMapper<>();
    static {
        propertyTypeMap.add("APPARTMENT", Property.Type.APPARTMENT);
        propertyTypeMap.add("HOUSE", Property.Type.HOUSE);
    }

    private static final EnumMapper<String, Property.RentType> propertyRentTypeMap = new EnumMapper<>();
    static {
        propertyRentTypeMap.add("SHORT_RENT", Property.RentType.SHORT);
        propertyRentTypeMap.add("LONG_RENT", Property.RentType.LONG);
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
                .type(propertyTypeMap.toFront(property.getType()))
                .rentType(propertyRentTypeMap.toFront(property.getRentType()))
                .buyPrice(property.getBuyPrice())
                .bankLoanSummary(new BankLoanSummary())
                .yearlyFees(feeService.getTotalFeesFrom(property.getId(), LocalDate.now().minusYears(1)))
                .yearlyIncomes(incomeService.getTotalIncomesFrom(property.getId(), LocalDate.now().minusYears(1)))
                .monthlyFees(feeService.getTotalFeesFrom(property.getId(), LocalDate.now().minusMonths(1)))
                .monthlyIncomes(incomeService.getTotalIncomesFrom(property.getId(), LocalDate.now().minusMonths(1)))
                .fees(convertToFeeSummaryList(feeService.getLastFees(property.getId(),5)))
                .incomes(convertToSummaryList(incomeService.getLastIncomes(property.getId(), 5)))
                .reservations(convertListToReservationSummary(reservationService.getLastReservations(property.getId(), 5)));
    }

    public List<PropertySummary>convertPropertyList(List<Property> propertyList){
        return propertyList.stream().map(this::convertToSummary).collect(Collectors.toList());
    }

    /**
     * INCOMES CONVERTERS
     */
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

    public IncomeSummary convertToSummary(Income income){
        return new IncomeSummary()
                .id(income.getId())
                .description(income.getDescription())
                .amount(income.getAmount())
                .date(income.getDate());
    }

    public List<IncomeSummary> convertToSummaryList(List<Income> incomes){
        return incomes.stream()
                .map(this::convertToSummary)
                .collect(Collectors.toList());
    }

    public List<IncomeDto> convertIncomeList(List<Income> incomeList){
        return incomeList.stream().map(this::convert).collect(Collectors.toList());
    }



    /**
     * RESERVATIONS CONVERTERS
     */
    public ReservationDetails convertToReservationDetails(Reservation reservation){
        return new ReservationDetails()
                .id(reservation.getId())
                .reservationDate(reservation.getReservationDate())
                .fromDate(reservation.getFromDate())
                .toDate(reservation.getToDate())
                .property(convert(reservation.getProperty()))
                .income(reservation.getIncome()!=null ?convert(reservation.getIncome()):null)
                .feeList(reservation.getFeeList()!=null && !reservation.getFeeList().isEmpty()? convertFeeList(reservation.getFeeList()):null);
    }

    public ReservationSummary convertToReservationSummary(Reservation reservation){
        return new ReservationSummary()
                .id(reservation.getId())
                .fromDate(reservation.getFromDate())
                .toDate(reservation.getToDate())
                .propertyName(reservation.getProperty().getName());
    }

    /**
     * Convert a reservationBody to a reservation entity
     * @param reservationBody the reservationBody to convert
     * @return the reservation entity
     */
    public Reservation convertToReservation(ReservationBody reservationBody){
        return new Reservation()
                .id(reservationBody.getId())
                .reservationDate(reservationBody.getReservationDate())
                .fromDate(reservationBody.getFromDate())
                .toDate(reservationBody.getToDate())
                .property(propertyService.getById(reservationBody.getPropertyId()));
    }

    public List<ReservationSummary> convertListToReservationSummary(List<Reservation> reservationList){
        return reservationList.stream().map(this::convertToReservationSummary).collect(Collectors.toList());
    }

    public ReservationCriteria convertToReservationCriteria(Integer propertyId, LocalDate fromDate, LocalDate toDate, LocalDate reservationDate, Integer pageSize, Integer pageNr){
        return new ReservationCriteria()
                .property(propertyId!=null?propertyService.getById(propertyId):null)
                .fromDate(fromDate)
                .toDate(toDate)
                .reservationDate(reservationDate)
                .pageSize(pageSize)
                .pageNumber(pageNr);
    }
}
