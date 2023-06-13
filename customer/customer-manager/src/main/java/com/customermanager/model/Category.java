package com.customermanager.model;

import java.time.LocalDate;

public class Category {
    private long idCategory;
    private String nameCategory;
    private LocalDate deleteAt;
    public Category(){}

    public Category(long idCategory, String nameCategory, LocalDate deleteAt) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.deleteAt = deleteAt;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public LocalDate getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDate deleteAt) {
        this.deleteAt = deleteAt;
    }
}
