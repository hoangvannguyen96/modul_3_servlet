package com.customermanager.service;

import com.customermanager.model.Customer;
import com.customermanager.model.CustomerType;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ICustomerMySqlIplm extends DBContext implements ICustomerService {
    public static final String FINDALL_CUSTOMER = "SELECT c.*, ct.nameType, ct.deleteAt FROM customer c join customertype ct on c.idType = ct.idType";
    public static final String SAVE_CUSTOMER = "INSERT INTO `salesproject`.`customer` (`name`, `email`, `address`, `createAt`, `idType`) VALUES (?, ?, ?, ?, ?)";
    public static final String FINDBYID_CUSTOMER = "SELECT * FROM customer where (`idCustomer`=?)";
    public static final String UPDATE_CUSTOMER = "UPDATE `salesproject`.`customer` SET `name` = ?, `email` = ?, `address` = ?, `createAt` = ?, `idType` = ? WHERE (`idcustomer` = ?)";
    public static final String DELETE_CUSTOMER = "DELETE FROM `salesproject`.`customer` WHERE (`idcustomer` = ?)";

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idcustomer = resultSet.getInt("idcustomer");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                java.util.Date createAt = resultSet.getDate("createAt");
                Date sqlcreateAt = resultSet.getDate("createAt");
                int idType = resultSet.getInt("idType");
                String nameType = resultSet.getString("nameType");
                Date sqldeleteAt = resultSet.getDate("deleteAt");
                LocalDate deleteAt = null;
                if (deleteAt != null) {
                    deleteAt = sqldeleteAt.toLocalDate();
                }
                CustomerType customerType = new CustomerType(idType, nameType, deleteAt);
                Customer customer = new Customer(idcustomer, name, email, address, createAt, idType, customerType);
                customers.add(customer);
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return customers;
    }

    @Override
    public List<Customer> findAllAfterDelete() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idcustomer = resultSet.getInt("idcustomer");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                java.util.Date createAt = resultSet.getDate("createAt");
                Date sqlcreateAt = resultSet.getDate("createAt");
                int idType = resultSet.getInt("idType");
                Customer customer = new Customer(idcustomer, name, email, address, createAt, idType);
                customers.add(customer);
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return customers;
    }

    @Override
    public void save(Customer customer) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CUSTOMER);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setDate(4, new Date(customer.getCreateAt().getTime()));
            preparedStatement.setInt(5, customer.getIdType());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }


    @Override
    public Customer findById(int idCustomer) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYID_CUSTOMER);
            preparedStatement.setInt(1, idCustomer);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idcutomer = resultSet.getInt("idcustomer");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                java.util.Date createAt = resultSet.getDate("createAt");
                int idType = resultSet.getInt("idType");
                Customer customer = new Customer(idcutomer, name, email, address, createAt, idType);
                return customer;
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return null;
    }

    @Override
    public void update(int id, Customer customer) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setDate(4, new Date(customer.getCreateAt().getTime()));
            preparedStatement.setInt(5, customer.getIdType());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }

    @Override
    public void remove(int idcustomer) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1, idcustomer);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }
}
