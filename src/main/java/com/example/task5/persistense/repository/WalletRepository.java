package com.example.task5.persistense.repository;

import com.example.task5.persistense.model.WalletEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends CrudRepository<WalletEntity, Long> {
}
