package com.easyimmo.income;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.easyimmo.EntityBuilder;
import com.easyimmo.common.exception.IncomeNotFoundException;
import com.easyimmo.common.utils.CustomValidator;
import com.easyimmo.incomes.dto.IncomeCriteria;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.incomes.repository.IncomeRepository;
import com.easyimmo.incomes.service.IncomeService;
import com.easyimmo.property.model.Property;

@SpringBootTest
class IncomeServiceUTest {

    @Mock
    CustomValidator customValidator;

    @Mock
    IncomeRepository incomeRepository;

    @InjectMocks
    IncomeService incomeService;

    @Test
    void getAllIncomesTest() {
        //Given
        IncomeCriteria criteria = new IncomeCriteria()
                .propertyId(1)
                .minDate(LocalDate.now())
                .maxDate(LocalDate.now())
                .minAmount(100)
                .maxAmount(200)
                .description("description")
                .propertyName("name")
                .pageNumber(1)
                .pageSize(10)
                .type(Income.IncomeType.SHORTRENT);
        //When
        incomeService.getAllIncomes(criteria);
        //Then
        Mockito.verify(incomeRepository, Mockito.times(1)).findIncomesByMultipleCriteria(criteria);
    }

    @Test
    void getIncomeByIdTest() {
        //Given
        Integer id = 1;
        //When
        Mockito.when(incomeRepository.findById(id)).thenReturn(Optional.of(new Income()));
        incomeService.getIncomeById(id);
        //Then
        Mockito.verify(incomeRepository,Mockito.times(1)).findById(id);
    }

    @Test
    void getIncomeByIdExceptionTest() {
        //Given
        Integer id = 1;
        //When Then
        Assertions.assertThrows(IncomeNotFoundException.class,()->incomeService.getIncomeById(id));
    }

    @Test
    void addIncomeTest() {
        //Given
        Income incomeToAdd = EntityBuilder.buildIncome(1000,EntityBuilder.buildProperty("test"));
        //When
        incomeService.addIncome(incomeToAdd);
        //Then
        Mockito.verify(incomeRepository,Mockito.times(1)).save(incomeToAdd);
    }

    @Test
    void getTotalIncomesFromTest() {
        //Given
        Integer propertyId = 5;
        LocalDate fromDate = LocalDate.now().minusDays(10);
        IncomeCriteria incomeCriteria = new IncomeCriteria().propertyId(propertyId).minDate(fromDate);
        //When
        incomeService.getTotalIncomesFrom(propertyId,fromDate);
        //Then
        Mockito.verify(incomeRepository,Mockito.times(1)).findIncomesByMultipleCriteria(incomeCriteria);
    }

    @Test
    void getLastIncomesTest() {
        //Given
        Integer propertyId = 1;
        Integer nbIncomes = 5;
        //When
        IncomeCriteria incomeCriteria = new IncomeCriteria().propertyId(propertyId).pageSize(nbIncomes).pageNumber(1);
        incomeService.getLastIncomes(propertyId,nbIncomes);
        //Then
        Mockito.verify(incomeRepository,Mockito.times(1)).findIncomesByMultipleCriteria(incomeCriteria);
    }

    @Test
    void deleteByIdTest() {
        //Given
        Integer id = 1;
        Income incomeToDelete = EntityBuilder.buildIncome(100, new Property());
        //When
        Mockito.when(incomeRepository.findById(id)).thenReturn(Optional.ofNullable(incomeToDelete));
        incomeService.deleteById(id);
        //Then
        Mockito.verify(incomeRepository,Mockito.times(1)).delete(incomeToDelete);
    }

    @Test
    void updateIncomeTest() {
        //Given
        Income income = EntityBuilder.buildIncome(100, new Property()).id(1231);
        Income incomeBody = new Income().incomeType(Income.IncomeType.EXCEPTIONAL).property(new Property().id(12)).amount(10012).description("description").date(LocalDate.now());
        Income updatedIncome = incomeBody.id(1231);
        //When
        Mockito.when(incomeRepository.findById(income.getId())).thenReturn(Optional.of(income));
        incomeService.updateIncome(income.getId(),incomeBody);
        //Then
        Mockito.verify(incomeRepository,Mockito.times(1)).save(updatedIncome);
    }
}
