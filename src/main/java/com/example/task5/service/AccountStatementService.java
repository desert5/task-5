package com.example.task5.service;

import com.example.task5.controller.request.Transaction;
import com.example.task5.controller.response.AccountStatement;
import com.example.task5.persistense.model.TransactionEntity;
import com.example.task5.persistense.model.WalletEntity;
import com.example.task5.persistense.repository.TransactionRepository;
import com.example.task5.persistense.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountStatementService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    public AccountStatement getStatement(Long walletId) {
        WalletEntity walletEntity = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet fro statement was not found"));

        return new AccountStatement(walletEntity.getBalance(), transactionRepository.findAllByFromOrTo(walletEntity, walletEntity).stream()
                .map(it -> new Transaction(
                        it.getFrom().getId(),
                        it.getTo().getId(),
                        it.getAmount())
                )
                .collect(Collectors.toList()));
    }
}
