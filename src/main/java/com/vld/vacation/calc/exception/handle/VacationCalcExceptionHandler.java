package com.vld.vacation.calc.exception.handle;

import com.vld.vacation.calc.exception.VacationCalcException;
import com.vld.vacation.calc.exception.model.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class VacationCalcExceptionHandler {

    @ExceptionHandler(VacationCalcException.class)
    public ResponseEntity<ErrorMessage> handle(VacationCalcException e) {
        return ResponseEntity.badRequest().body(
                ErrorMessage.builder()
                        .msg(e.getMessage())
                        .date(LocalDateTime.now())
                        .build());
    }
}
