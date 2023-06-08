package com.example.productmanagement.product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public void save(Product product);
    public void update(long id, Product product);
    public Product findById(long id);
    public void remove(long id);

}
