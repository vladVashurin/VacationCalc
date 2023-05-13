package com.vld.vacation.calc.service;

import com.vld.vacation.calc.exception.VacationCalcException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
public class VacationService {

    private final static List<LocalDate> HOLIDAYS = new ArrayList<>();

    static {
        HOLIDAYS.addAll(List.of(
                LocalDate.of(2023, 1, 2),
                LocalDate.of(2023, 1, 3),
                LocalDate.of(2023, 1, 4),
                LocalDate.of(2023, 1, 5),
                LocalDate.of(2023, 1, 6),
                LocalDate.of(2023, 2, 23),
                LocalDate.of(2023, 2, 24),
                LocalDate.of(2023, 3, 8),
                LocalDate.of(2023, 5, 1),
                LocalDate.of(2023, 5, 8),
                LocalDate.of(2023, 5, 9),
                LocalDate.of(2023, 6, 12),
                LocalDate.of(2023, 11, 6)));
    }

    public Double calculateVacationPay(Double yearSalary, LocalDate from, LocalDate to) {
        if (to.isBefore(from)) {
            throw new VacationCalcException(String.format("'from' date (%s) can not be after 'to' date (%s)", from, to));
        }
        if (from.getYear() != 2023 || to.getYear() != 2023) {
            throw new VacationCalcException("Production calendar does not exist");
        }

        long vacationDays = from.datesUntil(to.plusDays(1))
                .filter(localDate -> !HOLIDAYS.contains(localDate))
                .count();

        double daySalary = yearSalary / Year.of(from.getYear()).length();
        return vacationDays * daySalary;
    }
}