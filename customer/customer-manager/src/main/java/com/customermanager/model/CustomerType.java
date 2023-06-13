package com.customermanager.model;

import java.time.LocalDate;

public class CustomerType {
    private int idType;
    private String nameType;
    private LocalDate deleteAt;

    public CustomerType() {
    }

    public CustomerType(int idType, String nameType, LocalDate deleteAt) {
        this.idType = idType;
        this.nameType = nameType;
        this.deleteAt = deleteAt;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public LocalDate getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDate deleteAt) {
        this.deleteAt = deleteAt;
    }
}
