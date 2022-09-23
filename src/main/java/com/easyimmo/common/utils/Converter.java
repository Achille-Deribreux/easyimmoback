package com.easyimmo.common.utils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.easyimmo.bankloan.dto.BankloanBody;
import com.easyimmo.bankloan.dto.BankloanDetails;
import com.easyimmo.bankloan.model.Bankloan;
import com.easyimmo.bankloan.service.BankloanService;
import com.easyimmo.fees.dto.FeeDetails;
import com.easyimmo.fees.dto.FeeDto;
import com.easyimmo.fees.dto.FeeSummary;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.fees.service.FeeService;
import com.easyimmo.incomes.dto.IncomeBody;
import com.easyimmo.incomes.dto.IncomeDetails;
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

@Component
public class Converter {

    private final PropertyService propertyService;

    private final FeeService feeService;

    private final IncomeService incomeService;

    private final ReservationService reservationService;

    private final BankloanService bankloanService;


    public Converter(PropertyService propertyService, FeeService feeService, IncomeService incomeService, ReservationService reservationService, BankloanService bankloanService) {
        this.propertyService = propertyService;
        this.feeService = feeService;
        this.incomeService = incomeService;
        this.reservationService = reservationService;
        this.bankloanService = bankloanService;
    }

    /**
     * FEES CONVERTERS
     */
    public Fee convert(FeeDto feeDto){
        return new Fee(
                feeDto.getId(),
                feeDto.getPropertyId()!=null?propertyService.getById(feeDto.getPropertyId()):null,
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

    public FeeDetails convertToDetails(Fee fee){
        return new FeeDetails()
                .id(fee.getId())
                .property(fee.getProperty())
                .supplier(fee.getSupplier())
                .description(fee.getDescription())
                .amount(fee.getAmount())
                .date(fee.getDate());
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
        propertyRentTypeMap.add("SHORT", Property.RentType.SHORT);
        propertyRentTypeMap.add("LONG", Property.RentType.LONG);
    }



     public Property convert(PropertyDto propertyDto){
        return new Property()
                .id(propertyDto.getId())
                .address(propertyDto.getAddress())
                .name(propertyDto.getName())
                .type(propertyDto.getType())
                .rentType(propertyDto.getRentType())
                .buyPrice(propertyDto.getPrixAchat())
                .userId(propertyDto.getUserId());
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
                .bankLoanSummary(bankloanService.getBankLoanSummaryByProperty(property))
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
    public IncomeDetails convertToDetails(Income income){
        return new IncomeDetails()
                .id(income.getId())
                .property(convertToSummary(income.getProperty()))
                .amount(income.getAmount())
                .description(income.getDescription())
                .incomeType(income.getIncomeType())
                .date(income.getDate());
    }

    public Income convert(IncomeBody incomeBody){
        return new Income(
                incomeBody.getId(),
                propertyService.getById(incomeBody.getPropertyId()),
                incomeBody.getAmount(),
                incomeBody.getDescription(),
                incomeBody.getDate(),
                incomeBody.getIncomeType()
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
                .income(reservation.getIncome()!=null ?convertToSummary(reservation.getIncome()):null)
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

    /**
     * BANK LOAN CONVERTERS
     */
    public Bankloan convertToBankloan(BankloanBody bankloanBody){
        return new Bankloan()
                .id(bankloanBody.getId())
                .totalAmount(bankloanBody.getTotalAmount())
                .startDate(bankloanBody.getStartDate())
                .endDate(bankloanBody.getEndDate())
                .monthlyPayment(bankloanBody.getMonthlyPayment())
                .property(bankloanBody.getPropertyId()!=null?propertyService.getById(bankloanBody.getPropertyId()):null);
    }

    public BankloanDetails convertToBankloanDetails(Bankloan bankloan){
        return new BankloanDetails()
                .id(bankloan.getId())
                .totalAmount(bankloan.getTotalAmount())
                .startDate(bankloan.getStartDate())
                .endDate(bankloan.getEndDate())
                .monthlyPayment(bankloan.getMonthlyPayment());
    }
}
