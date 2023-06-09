package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceIplm implements IProductService{
    private static Map<Long,Product> products;
    static {
        products=new HashMap<>();
        products.put(1234567890L,new Product(1234567890,"sữa tươi",8000,"thơm, ngon","Vinamilk"));
        products.put(1234566350L,new Product(1234566350,"bia huda",11000,"đậm vị","Carlber"));
        products.put(1238567890L,new Product(1238567890,"whisky",1200000,"nồng nàn","Ireland"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void add(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void update(long id, Product product) {
        products.put(id,product);
    }

    @Override
    public void delete(long id) {
        products.remove(id);
    }

    @Override
    public Product findById(long id) {
        return products.get(id);
    }
}
