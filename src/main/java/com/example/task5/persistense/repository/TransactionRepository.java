package com.example.task5.persistense.repository;

import com.example.task5.persistense.model.TransactionEntity;
import com.example.task5.persistense.model.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    List<TransactionEntity> findAllByFromOrTo(WalletEntity from, WalletEntity to);
}
