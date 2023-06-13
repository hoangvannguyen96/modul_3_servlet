package com.customermanager.service;

import com.customermanager.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    List<Customer> findAllAfterDelete();
    void save(Customer customer);
    Customer findById(int id);
    void update(int id, Customer customer);
    void remove(int id);
}
