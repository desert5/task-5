package com.example.task5.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Transaction {
    private Long from;
    private Long to;
    private BigDecimal amount;
}
