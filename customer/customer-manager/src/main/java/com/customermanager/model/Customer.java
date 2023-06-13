package com.customermanager.model;

import java.util.Date;

public class Customer {
    private int idCustomer;
    private String name;
    private String email;
    private String address;
    private Date createAt;
    private int idType;
    private CustomerType customerType;


    public Customer() {
    }

    public Customer(int idCustomer, String name, String email, String address) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Customer(int idCustomer, String name, String email, String address, Date createAt, int idType) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.email = email;
        this.address = address;
        this.createAt = createAt;
        this.idType = idType;
    }

    public Customer(int idCustomer, String name, String email, String address, Date createAt, CustomerType customerType) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.email = email;
        this.address = address;
        this.createAt = createAt;
        this.customerType = customerType;
    }

    public Customer(int idCustomer, String name, String email, String address, Date createAt, int idType, CustomerType customerType) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.email = email;
        this.address = address;
        this.createAt = createAt;
        this.idType = idType;
        this.customerType = customerType;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
