package com.customermanager.service;

import com.customermanager.model.Product;
import com.customermanager.model.User;

import java.util.List;

public interface IUser {
    List<User> findAll();
    void save(User user);
    User findById(long idUser);
    void update(long idUser, User user);
    void remove(long idUser);
}
