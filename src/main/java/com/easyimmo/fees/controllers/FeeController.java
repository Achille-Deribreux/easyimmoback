package com.easyimmo.fees.controllers;

import com.easyimmo.common.utils.Converter;
import com.easyimmo.fees.dto.FeeCriteria;
import com.easyimmo.fees.dto.FeeDto;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.fees.service.FeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/fee")
public class FeeController {

    //TODO : JavaDoc & logs + verifications
    
    private final FeeService feeService;

    private final Converter converter;

    public FeeController(FeeService feeService, Converter convert) {
        this.feeService = feeService;
        this.converter = convert;
    }

    @GetMapping(value="/getById")
    public ResponseEntity<FeeDto>getFeeById(@RequestParam(value="id")Integer id){
        return new ResponseEntity<>(converter.convert(feeService.getFeeById(id)), HttpStatus.OK);
    }

    @PostMapping(value="/add")
    public ResponseEntity<FeeDto>addFee(@RequestBody FeeDto feeDto){
        Fee addedFee = feeService.addFee(converter.convert(feeDto));
        return new ResponseEntity<>(converter.convert(addedFee),HttpStatus.CREATED);
    }

    @PutMapping(value="/update")
    public ResponseEntity<FeeDto>editFee(
            @RequestParam(value = "id")Integer id,
            @RequestBody FeeDto feeDto){
        Fee updatedFee = feeService.updateFee(id, converter.convert(feeDto));
        return new ResponseEntity<>(converter.convert(updatedFee), HttpStatus.CREATED);
    }

    @GetMapping(value="getAll")
    public ResponseEntity<List<FeeDto>>getAllFees(
            @RequestParam(value = "propertyName",required=false)String propertyName,
            @RequestParam(value = "propertyId",required=false)Integer propertyId,
            @RequestParam(value = "supplier",required=false)String supplier,
            @RequestParam(value = "description",required=false)String description,
            @RequestParam(value="minAmount",required=false)Integer minAmount,
            @RequestParam(value="maxAmount",required=false)Integer maxAmount,
            @RequestParam(value="minDate",required=false) LocalDate minDate,
            @RequestParam(value="maxDate",required=false) LocalDate maxDate
    ){
        FeeCriteria feeCriteria = new FeeCriteria()
                .propertyName(propertyName)
                .propertyId(propertyId)
                .supplier(supplier)
                .description(description)
                .minAmount(minAmount)
                .maxAmount(maxAmount)
                .minDate(minDate)
                .maxaDate(maxDate);

        List<Fee> result = feeService.getAllFees(feeCriteria);
        if (result.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(converter.convertFeeList(result),HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteById")
    public ResponseEntity<String> deleteFeeById(@RequestParam(value="id")Integer id){
        feeService.deleteById(id);
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }
}
