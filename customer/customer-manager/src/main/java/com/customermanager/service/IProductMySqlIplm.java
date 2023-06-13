package com.customermanager.service;

import com.customermanager.model.Category;
import com.customermanager.model.Product;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IProductMySqlIplm extends DBContext implements IProductService {
    public static final String FINDALL_CUSTOMER = "SELECT p.*, cate.nameCategory, cate.deleteAt FROM product p join category cate on p.idCategory = cate.idCategory;";
    public static final String SAVE_CUSTOMER = "INSERT INTO `salesproject`.`product` (`nameProduct`, `description`, `createAt`, `price`, `idCategory`) VALUES (?, ?, ?, ?, ?);";
    public static final String FINDBYID_CUSTOMER = "SELECT * FROM salesproject.product where (`idProduct`=?)";
    public static final String UPDATE_CUSTOMER = "UPDATE `salesproject`.`product` SET `nameProduct` = ?, `description` = ?, `createAt` = ?, `price` = ?, `idCategory`=? WHERE (`idProduct` = ?);";
    public static final String DELETE_CUSTOMER = "DELETE FROM `salesproject`.`product` WHERE (`idProduct` = ?);";

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idProduct = resultSet.getLong("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                String description = resultSet.getString("description");
                LocalDate createAt = resultSet.getDate("createAt").toLocalDate();
                float price = resultSet.getFloat("price");
                long idCategory = resultSet.getLong("idCategory");
                String nameCategory = resultSet.getString("nameCategory");
                Date sqldeleteAt = resultSet.getDate("deleteAt");
                LocalDate deleteAt = null;
                if (sqldeleteAt != null) {
                    deleteAt = sqldeleteAt.toLocalDate();
                }
                Category category = new Category(idCategory, nameCategory, deleteAt);
                Product product = new Product(idProduct, nameProduct, description, createAt, price, idCategory, category);
                products.add(product);
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return products;
    }

    @Override
    public void save(Product product) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CUSTOMER);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDate(3, Date.valueOf(product.getCreateAt()));
            preparedStatement.setFloat(4, product.getPrice());
            preparedStatement.setLong(5, product.getIdCategory());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }

    @Override
    public Product findById(long idProduct) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYID_CUSTOMER);
            preparedStatement.setLong(1, idProduct);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idProduct1 = resultSet.getLong("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                String description = resultSet.getString("description");
                LocalDate createAt = resultSet.getDate("createAt").toLocalDate();
                float price = resultSet.getFloat("price");
                long idCategory = resultSet.getLong("idCategory");
                Product product = new Product(idProduct1, nameProduct, description, createAt, price, idCategory);
                return product;
            }
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return null;
    }

    @Override
    public void update(long idProduct, Product product) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDate(3, Date.valueOf(product.getCreateAt()));
            preparedStatement.setFloat(4, product.getPrice());
            preparedStatement.setLong(5, product.getIdCategory());
            preparedStatement.setLong(6, idProduct);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }

    @Override
    public void remove(long idProduct) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setLong(1, idProduct);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }
}
