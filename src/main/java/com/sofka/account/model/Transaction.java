package com.sofka.account.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(schema = "core")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    private LocalDateTime datetimeTransaction;
    @Column(precision = 18, scale = 2)
    private BigDecimal amount;
    @Column(length = 36)
    private String accountId;
    @Column(precision = 18, scale = 2)
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id")
    private TransactionType transactionType;

    public Transaction() {
    }

    public Transaction(String id, LocalDateTime datetimeTransaction, BigDecimal amount, String accountId, BigDecimal balance, TransactionType transactionType) {
        this.id = id;
        this.datetimeTransaction = datetimeTransaction;
        this.amount = amount;
        this.accountId = accountId;
        this.balance = balance;
        this.transactionType = transactionType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDatetimeTransaction() {
        return datetimeTransaction;
    }

    public void setDatetimeTransaction(LocalDateTime datetimeTransaction) {
        this.datetimeTransaction = datetimeTransaction;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
