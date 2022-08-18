package com.easyimmo.income;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.easyimmo.incomes.repository.IncomeRepository;
import com.easyimmo.incomes.service.IncomeService;

@SpringBootTest
public class IncomeServiceUTest {

    @Mock
    IncomeRepository incomeRepository;

    @InjectMocks
    IncomeService incomeService;
}
