package com.example.task5.persistense.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_ENTITY_SEQ")
    private Long id;

    @ManyToOne
    private WalletEntity from;

    @ManyToOne
    private WalletEntity to;

    private BigDecimal amount;
}
