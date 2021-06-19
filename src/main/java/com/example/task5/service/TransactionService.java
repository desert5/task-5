package com.example.task5.service;

import com.example.task5.persistense.model.TransactionEntity;
import com.example.task5.persistense.model.WalletEntity;
import com.example.task5.persistense.repository.TransactionRepository;
import com.example.task5.persistense.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    public void transfer(Long from, Long to, BigDecimal amount) {
        WalletEntity sourceWallet = walletRepository.findById(from).orElseThrow(() -> new RuntimeException("Source wallet was not found"));
        WalletEntity targetWallet = walletRepository.findById(to).orElseThrow(() -> new RuntimeException("Target wallet was not found"));
        transfer(sourceWallet, targetWallet, amount);
    }

    private void transfer(WalletEntity from, WalletEntity to, BigDecimal amount) {
        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        TransactionEntity transaction = new TransactionEntity();
        transaction.setFrom(from);
        transaction.setTo(to);
        transaction.setAmount(amount);
        transactionRepository.save(transaction);
    }

    @Transactional
    public List<TransactionEntity> list() {
        return transactionRepository.findAll();
    }
}
