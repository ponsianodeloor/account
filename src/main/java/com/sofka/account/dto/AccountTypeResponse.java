package com.sofka.account.dto;

public class AccountTypeResponse {
    private String id;
    private String name;
    private String code;
    private String description;
    private Boolean state;

    public AccountTypeResponse() {
    }

    public AccountTypeResponse(String id, String name, String code, String description, Boolean state) {
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
}
