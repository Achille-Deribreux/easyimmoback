package com.easyimmo.incomes.controller;

import com.easyimmo.common.utils.Converter;
import com.easyimmo.incomes.dto.IncomeCriteria;
import com.easyimmo.incomes.dto.IncomeDto;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.incomes.service.IncomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/income")
public class IncomeController {

    private final IncomeService incomeService;

    private final Converter converter;

    private final Logger logger = LoggerFactory.getLogger(IncomeController.class);

    public IncomeController(IncomeService incomeService, Converter converter) {
        this.incomeService = incomeService;
        this.converter = converter;
    }

    @GetMapping("/getById")
    public ResponseEntity<IncomeDto> getIncomeById(@RequestParam(value = "id")Integer id){
        logger.info("request received at /income/getById with id : {}", id);
        return new ResponseEntity<>(converter.convert(incomeService.getIncomeById(id)), HttpStatus.OK);
    }

    @PostMapping(value="/add")
    public ResponseEntity<IncomeDto>addIncome(@RequestBody IncomeDto incomeDto){
        Income addedIncome = incomeService.addIncome(converter.convert(incomeDto));
        return new ResponseEntity<>(converter.convert(addedIncome),HttpStatus.CREATED);
    }

    @PutMapping(value="/update")
    public ResponseEntity<IncomeDto>editIncome(
            @RequestParam(value = "id")Integer id,
            @RequestBody IncomeDto incomeDto){
        Income updatedIncome = incomeService.updateIncome(id, converter.convert(incomeDto));
        return new ResponseEntity<>(converter.convert(updatedIncome), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<IncomeDto>> getAllIncomes(
            @RequestParam(value = "incomeType", required = false)Income.IncomeType type,
            @RequestParam(value = "propertyId",required=false)Integer propertyId,
            @RequestParam(value = "propertyName", required = false)String propertyName,
            @RequestParam(value = "minAmount", required = false)Integer minAmount,
            @RequestParam(value = "maxAmount", required = false)Integer maxAmount,
            @RequestParam(value = "description", required = false)String description,
            @RequestParam(value="minDate",required=false) LocalDate minDate,
            @RequestParam(value="maxDate",required=false) LocalDate maxDate,
            @RequestParam(value="pageNr",required=false)Integer pageNr,
            @RequestParam(value="pageSize",required=false)Integer pageSize
            ){
        logger.info("get request received at /income/getAll");
        IncomeCriteria incomeCriteria = new IncomeCriteria()
                .type(type)
                .propertyId(propertyId)
                .propertyName(propertyName)
                .minAmount(minAmount)
                .maxAmount(maxAmount)
                .description(description)
                .minDate(minDate)
                .maxDate(maxDate)
                .pageNumber(pageNr)
                .pageSize(pageSize);
        List<Income> allIncomeList = incomeService.getAllIncomes(incomeCriteria);
        if(allIncomeList.isEmpty())
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(converter.convertIncomeList(allIncomeList),HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteById")
    public ResponseEntity<String> deleteFeeById(@RequestParam(value="id")Integer id){
        logger.info("delete request received at /income/deleteById");
        incomeService.deleteById(id);
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }
}
