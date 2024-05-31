package com.sofka.account.model;

public class Person {
    private String id;
    private String name;
    private String lastname;
    private String phone;
    private String address;

    public Person() {
    }

    public Person(String id, String name, String lastname, String phone, String address) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
