package com.sofka.account.repository;

import com.sofka.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findByDatetimeTransactionBetween(Date datetimeTransaction, Date datetimeTransaction2);
}
