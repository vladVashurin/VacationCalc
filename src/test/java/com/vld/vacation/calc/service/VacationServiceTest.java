package com.VacationCalc.service;

import com.VacationCalc.exception.DateToBeforeFrom;
import com.VacationCalc.exception.NotExistException;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class VacationServiceTest {
  private VacationService vacationService = new VacationService();

    @Test
    public void calculateVacationPay() {
        LocalDate from = LocalDate.of(2023, 06, 19);
        LocalDate to = LocalDate.of(2023, 07, 25);
        Double avgSalary = 30000.0;
        Double vacPayment = vacationService.calculateVacationPay(avgSalary, from, to);
        Double expectedSalary = 12 * 30000.0 / 365 * 37;
        assertEquals(vacPayment, expectedSalary);
    }

    @Test(expected = NotExistException.class)
    public void calculateVacationPayNotExist() {
        LocalDate from = LocalDate.of(2023, 06, 19);
        LocalDate to = LocalDate.of(2024, 07, 25);
        Double avgSalary = 30000.0;
        vacationService.calculateVacationPay(avgSalary, from, to);
    }

    @Test(expected = DateToBeforeFrom.class)
    public void calculateDateToBeforeFrom() {
        LocalDate from = LocalDate.of(2023, 06, 19);
        LocalDate to = LocalDate.of(2023, 05, 25);
        Double avgSalary = 35000.0;
        vacationService.calculateVacationPay(avgSalary, from, to);
    }
}