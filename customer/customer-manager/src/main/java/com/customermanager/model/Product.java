package com.customermanager.model;

import java.time.LocalDate;

public class Product {
    private long idProduct;
    private String nameProduct;
    private String description;
    private LocalDate createAt;
    private float price;
    private long idCategory;
    private Category category;

    public Product() {
    }

    public Product(long idProduct, String nameProduct, String description, LocalDate createAt, float price, long idCategory) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.description = description;
        this.createAt = createAt;
        this.price = price;
        this.idCategory = idCategory;
    }

    public Product(long idProduct, String nameProduct, String description, LocalDate createAt, float price, long idCategory, Category category) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.description = description;
        this.createAt = createAt;
        this.price = price;
        this.idCategory = idCategory;
        this.category = category;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
