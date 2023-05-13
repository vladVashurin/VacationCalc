package com.vld.vacation.calc.service;

import com.vld.vacation.calc.exception.VacationCalcException;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class VacationServiceTest {

    private VacationService vacationService;

    @Before
    public void beforeEach() {
        vacationService = new VacationService();
    }

    @Test
    public void calculateVacationPay() {

        LocalDate from = LocalDate.of(2023, 6, 19);
        LocalDate to = LocalDate.of(2023, 7, 25);
        Double avgSalary = 30000.0;
        Double vacPayment = vacationService.calculateVacationPay(avgSalary, from, to);
        Double expectedSalary = 30000.0 / 365 * 37;
        assertEquals(vacPayment, expectedSalary);
    }

    @Test(expected = VacationCalcException.class)
    public void calculateVacationPayNotExist() {
        LocalDate from = LocalDate.of(2023, 6, 19);
        LocalDate to = LocalDate.of(2024, 7, 25);
        Double avgSalary = 30000.0;
        vacationService.calculateVacationPay(avgSalary, from, to);
    }

    @Test(expected = VacationCalcException.class)
    public void calculateDateToBeforeFrom() {
        LocalDate from = LocalDate.of(2023, 6, 19);
        LocalDate to = LocalDate.of(2023, 5, 25);
        Double avgSalary = 35000.0;
        vacationService.calculateVacationPay(avgSalary, from, to);
    }
}