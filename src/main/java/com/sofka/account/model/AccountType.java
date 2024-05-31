package com.sofka.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "account")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    @Column(length = 20)
    private String name;
    @Column(length = 2)
    private String code;
    @Column(length = 100)
    private String description;
    private Boolean state;

    @JsonIgnore
    @OneToMany(mappedBy = "accountType", cascade = {CascadeType.ALL})
    private Set<Account> accounts = new HashSet<>();

    public AccountType() {
    }

    public AccountType(String id, String name, String code, String description, Boolean state) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
