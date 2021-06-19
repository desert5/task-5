package com.example.task5;

import com.example.task5.persistense.model.WalletEntity;
import com.example.task5.persistense.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final WalletRepository walletRepository;

    @Override
    public void run(ApplicationArguments args) {
        WalletEntity wallet = new WalletEntity();
        wallet.setId(1L);
        wallet.setBalance(new BigDecimal("123"));
        walletRepository.save(wallet);

        WalletEntity wallet2 = new WalletEntity();
        wallet2.setId(2L);
        wallet2.setBalance(new BigDecimal("456"));
        walletRepository.save(wallet2);

        WalletEntity wallet3 = new WalletEntity();
        wallet3.setId(3L);
        wallet3.setBalance(new BigDecimal("789"));
        walletRepository.save(wallet3);
    }
}
