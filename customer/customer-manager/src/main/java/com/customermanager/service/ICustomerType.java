package com.customermanager.service;

import com.customermanager.model.CustomerType;

import java.util.List;

public interface ICustomerType {
    List<CustomerType> findAll();
    CustomerType findById(int id);
}
