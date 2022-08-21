package com.easyimmo.fees.controllers;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easyimmo.common.utils.Converter;
import com.easyimmo.fees.dto.FeeCriteria;
import com.easyimmo.fees.dto.FeeDetails;
import com.easyimmo.fees.dto.FeeDto;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.fees.service.FeeService;

@RestController
@RequestMapping("/fee")
public class FeeController {
    
    private final FeeService feeService;

    private final Converter converter;

    private final Logger logger = LoggerFactory.getLogger(FeeController.class);

    public FeeController(FeeService feeService, Converter convert) {
        this.feeService = feeService;
        this.converter = convert;
    }

    /**
     * This method answer to a request at : /fee/getById and returns a response entity with the wanted fee
     * @param id id of the wanted fee
     * @return response entity with the wanted fee and status code 200 if everything is ok
     */
    @GetMapping(value="/getById")
    public ResponseEntity<FeeDetails>getFeeById(@RequestParam(value="id")Integer id){
        logger.info("get request received at fee/getById for id : {}", id);
        return new ResponseEntity<>(converter.convertToDetails(feeService.getFeeById(id)), HttpStatus.OK);
    }

    /**
     * This method answer to a request at : /fee/add and returns a response entity with the added fee
     * @param feeDto fee to add
     * @return response entity with the added fee and status code 201 if everything is ok
     */
    @PostMapping(value="/add")
    public ResponseEntity<FeeDto>addFee(@RequestBody FeeDto feeDto){
        logger.info("post request received at fee/add for fee : {}", feeDto);
        Fee addedFee = feeService.addFee(converter.convert(feeDto));
        return new ResponseEntity<>(converter.convert(addedFee),HttpStatus.CREATED);
    }

    /**
     * This method answer to a request at : /fee/update and returns a response entity with the updated fee
     * @param feeDto fee to update
     * @return response entity with the updated fee and status code 201 if everything is ok
     */
    @PutMapping(value="/update")
    public ResponseEntity<FeeDto>editFee(
            @RequestParam(value = "id")Integer id,
            @RequestBody FeeDto feeDto){
        logger.info("put request received at fee/update for id : {} and fee : {}", id, feeDto);
        Fee updatedFee = feeService.updateFee(id, converter.convert(feeDto));
        return new ResponseEntity<>(converter.convert(updatedFee), HttpStatus.CREATED);
    }

    /**
     * This method answer to a request at : /fee/getAll and returns a response entity with the all the fees which correspond to the criteria
     * @return a list of all the fees and status code 200 if everything is ok
     */
    @GetMapping(value="getAll")
    public ResponseEntity<List<FeeDto>>getAllFees(
            @RequestParam(value = "propertyName",required=false)String propertyName,
            @RequestParam(value = "propertyId",required=false)Integer propertyId,
            @RequestParam(value = "supplier",required=false)String supplier,
            @RequestParam(value = "description",required=false)String description,
            @RequestParam(value="minAmount",required=false)Integer minAmount,
            @RequestParam(value="maxAmount",required=false)Integer maxAmount,
            @RequestParam(value="minDate",required=false) LocalDate minDate,
            @RequestParam(value="maxDate",required=false) LocalDate maxDate,
            @RequestParam(value="pageNr",required=false)Integer pageNr,
            @RequestParam(value="pageSize",required=false)Integer pageSize
    ){
        logger.info("get request received at fee/getAll");
        FeeCriteria feeCriteria = new FeeCriteria()
                .propertyName(propertyName)
                .propertyId(propertyId)
                .supplier(supplier)
                .description(description)
                .minAmount(minAmount)
                .maxAmount(maxAmount)
                .minDate(minDate)
                .maxDate(maxDate)
                .pageSize(pageSize)
                .pageNumber(pageNr);

        List<Fee> result = feeService.getAllFees(feeCriteria);
        if (result.isEmpty()){
            logger.info("no fee found for criteria : {}", feeCriteria);
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(converter.convertFeeList(result),HttpStatus.OK);
    }

    /**
     * This method answer to a request at : /fee/delete and returns a string
     * @param id id of the fee to delete
     * @return string and status code 200 if everything is ok
     */
    @DeleteMapping(value="/deleteById")
    public ResponseEntity<String> deleteFeeById(@RequestParam(value="id")Integer id){
        logger.info("delete request received at fee/deleteById for id : {}", id);
        feeService.deleteById(id);
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }
}
