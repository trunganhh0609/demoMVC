package com.example.demo.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Employee {

    private long id;
    @NotNull
    @NotBlank(message = "Name can't be null")
    private String name;
    @NotNull
    @NotBlank(message = "address can't be null")
    private String address;

    public Employee() {
    }

    public Employee(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
