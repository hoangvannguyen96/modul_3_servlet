package com.customermanager.service;

import com.customermanager.model.Customer;
import com.customermanager.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(long idProduct);
    void update(long idProduct, Product product);
    void remove(long idProduct);
}
