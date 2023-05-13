package com.vld.vacation.calc.controller;

import com.vld.vacation.calc.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class VacationController {
    private final VacationService vacationService;

    @Autowired
    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }


    @GetMapping("/calculate")
    public Double get(@RequestParam Double yearSalary,
                      @RequestParam LocalDate from,
                      @RequestParam LocalDate to) {
        return vacationService.calculateVacationPay(yearSalary, from, to);
    }

    //my: http://localhost:8088/calculate?yearSalary=1800000&from=2023-05-10&to=2023-05-20
    //default:http://localhost:8080/calculate?yearSalary=1800000&from=2023-05-10&to=2023-05-20
}

