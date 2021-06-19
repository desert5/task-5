package com.example.task5.persistense.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WALLET_ENTITY_SEQ")
    private Long id;

    private BigDecimal balance;
}
