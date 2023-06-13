package com.customermanager.model;

import java.time.LocalDate;

public class User {
    private long idUser;
    private String fullName;
    private String address;
    private LocalDate dob;
    private LocalDate deleteAt;
    private ERole role;

    public User() {
    }

    public User(long idUser, String fullName, String address, LocalDate dob, ERole role) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.address = address;
        this.dob = dob;
        this.role = role;
    }

    public User(long idUser, String fullName, String address, LocalDate dob, LocalDate deleteAt, ERole role) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.address = address;
        this.dob = dob;
        this.deleteAt = deleteAt;
        this.role = role;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDate deleteAt) {
        this.deleteAt = deleteAt;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
