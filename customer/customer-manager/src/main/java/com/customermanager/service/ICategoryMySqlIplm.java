package com.customermanager.service;

import com.customermanager.model.Category;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ICategoryMySqlIplm extends DBContext implements ICategory {
    public static final String FINDALL_CATEGORY="SELECT * FROM salesproject.category;";
    public static final String FINDBYID_CATEGORY="SELECT * FROM salesproject.category where (`idCategory`=?);";
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idCategory = resultSet.getLong("idCategory");
                String nameCategory = resultSet.getString("nameCategory");
                Date sqldeleteAt = resultSet.getDate("deleteAt");
                LocalDate deleteAt = null;
                if (sqldeleteAt != null) {
                    deleteAt = sqldeleteAt.toLocalDate();
                }
                Category category = new Category(idCategory, nameCategory, deleteAt);
                categories.add(category);
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return categories;
    }

    @Override
    public Category findById(long idCategory) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYID_CATEGORY);
            preparedStatement.setLong(1, idCategory);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idCategory1 = resultSet.getLong("idCategory");
                String nameCategory = resultSet.getString("nameCategory");
                Date sqldeleteAt = resultSet.getDate("deleteAt");
                LocalDate deleteAt = null;
                if (sqldeleteAt != null) {
                    deleteAt = sqldeleteAt.toLocalDate();
                }
                Category category = new Category(idCategory1, nameCategory, deleteAt);
                return category;
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return null;
    }
}
