package com.example.productmanagement.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceIplm implements ProductService {
    public static Map<Long, Product> products;

    static {
        products = new HashMap<>();
        products.put((System.currentTimeMillis() / 1000), new Product(System.currentTimeMillis() / 1000, "Sữa cô gái hàng xóm", 10000, "thơm, ngon", "Vinamilk"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(long id, Product product) {
        products.put(id, product);
    }

    @Override
    public Product findById(long id) {
        return products.get(id);
    }

    @Override
    public void remove(long id) {
        products.remove(id);
    }
}
