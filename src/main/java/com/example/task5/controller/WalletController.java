package com.example.task5.controller;

import com.example.task5.controller.response.AccountStatement;
import com.example.task5.service.AccountStatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final AccountStatementService accountStatementService;

    @GetMapping("/{id}/statement")
    public AccountStatement getStatement(@PathVariable("id") Long walletId) {
        return accountStatementService.getStatement(walletId);
    }

}
