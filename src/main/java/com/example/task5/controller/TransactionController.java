package com.example.task5.controller;

import com.example.task5.controller.request.Transaction;
import com.example.task5.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public void createTransaction(@RequestBody Transaction request) {
        transactionService.transfer(request.getFrom(), request.getTo(), request.getAmount());
    }

    @GetMapping
    public List<Transaction> listTransactions() {
        return transactionService.list().stream()
                .map(it -> new Transaction(
                        it.getFrom().getId(),
                        it.getTo().getId(),
                        it.getAmount())
                )
                .collect(Collectors.toList());
    }
}
