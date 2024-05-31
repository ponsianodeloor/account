package com.sofka.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(schema = "core")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    @Column(columnDefinition = "date")
    private Date datetimeTransaction;
    @Column(precision = 18, scale = 2)
    private BigDecimal amount;
    @Column(length = 36)
    private String accountId;
    @Column(precision = 18, scale = 2)
    private BigDecimal balance;
    @Column(precision = 18, scale = 2)
    private BigDecimal newBalance;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "transaction_type_id")
    private TransactionType transactionType;

    public Transaction() {
    }

    public Transaction(String id, Date datetimeTransaction, BigDecimal amount, String accountId, BigDecimal balance, BigDecimal newBalance, TransactionType transactionType) {
        this.id = id;
        this.datetimeTransaction = datetimeTransaction;
        this.amount = amount;
        this.accountId = accountId;
        this.balance = balance;
        this.newBalance = newBalance;
        this.transactionType = transactionType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDatetimeTransaction() {
        return datetimeTransaction;
    }

    public void setDatetimeTransaction(Date datetimeTransaction) {
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

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
