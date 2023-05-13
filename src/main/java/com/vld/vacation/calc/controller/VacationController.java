package com.VacationCalc.controller;

import com.VacationCalc.exception.NotExistException;
import com.VacationCalc.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class VacationController {

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

   @Autowired
   private final VacationService vacationService;

    @GetMapping("/calculate")
    public Double get(@RequestParam Double avgSalary,
                      @RequestParam LocalDate from,
                      @RequestParam LocalDate to) throws NotExistException {
        return vacationService.calculateVacationPay(avgSalary, from, to);
    }

        //my: http://localhost:8088/calculate?salary=1800000&from=2023-05-10&to=2023-05-20
       //default:http://localhost:8080/calculate?salary=1800000&from=2023-05-10&to=2023-05-20
}

