package com.example.productmanagement.product;

public class Product {
    private long id;
    private String nameProduct;
    private float priceProduct;
    private String description;
    private String producer;

    public Product() {
    }

    public Product(long id, String nameProduct, float priceProduct, String description, String producer) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.description = description;
        this.producer = producer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public float getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(float priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
