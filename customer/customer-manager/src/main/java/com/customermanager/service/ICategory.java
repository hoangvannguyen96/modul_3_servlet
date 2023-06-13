package com.customermanager.service;

import com.customermanager.model.Category;
import com.customermanager.model.CustomerType;

import java.util.List;

public interface ICategory {
    List<Category> findAll();

    Category findById(long idCategory);
}
