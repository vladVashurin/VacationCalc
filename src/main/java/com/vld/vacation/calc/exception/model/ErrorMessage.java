package com.vld.vacation.calc.exception.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorMessage {

    private LocalDateTime date;
    private String msg;
}
