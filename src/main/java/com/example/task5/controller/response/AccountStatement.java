package com.example.task5.controller.response;

import com.example.task5.persistense.model.TransactionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class AccountStatement {
    private BigDecimal amount;
    private List<TransactionEntity> transaction;
}
