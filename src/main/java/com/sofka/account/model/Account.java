package com.sofka.account.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(schema = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Column(length = 10)
    private String accountNumber;
    private BigDecimal balance;
    private Boolean state;
    private String clientId;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;

    public Account() {
    }

    public Account(String id, String accountNumber, BigDecimal balance, Boolean state, String clientId, AccountType accountType) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.state = state;
        this.clientId = clientId;
        this.accountType = accountType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
