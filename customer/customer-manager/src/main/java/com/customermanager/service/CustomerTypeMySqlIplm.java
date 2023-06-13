package com.customermanager.service;

import com.customermanager.model.CustomerType;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeMySqlIplm extends DBContext implements ICustomerType {
    public static final String FINDALL_CUSTOMERTYPE="SELECT * FROM salesproject.customertype;";
    public static final String FINDBYID_CUSTOMERTYPE="SELECT * FROM salesproject.customertype where (`idType`=?);";
    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> customerTypes = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL_CUSTOMERTYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idType = resultSet.getInt("idType");
                String nameType = resultSet.getString("nameType");
                Date sqldeleteAt = resultSet.getDate("deleteAt");
                LocalDate deleteAt = null;
                if (deleteAt != null) {
                    deleteAt = sqldeleteAt.toLocalDate();
                }
                CustomerType customerType = new CustomerType(idType, nameType, deleteAt);
                customerTypes.add(customerType);
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return customerTypes;
    }

    @Override
    public CustomerType findById(int id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYID_CUSTOMERTYPE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idType = resultSet.getInt("idType");
                String nameType = resultSet.getString("nameType");
                Date sqldeleteAt = resultSet.getDate("deleteAt");
                LocalDate deleteAt = null;
                if (deleteAt != null) {
                    deleteAt = sqldeleteAt.toLocalDate();
                }
                CustomerType customerType = new CustomerType(idType, nameType, deleteAt);
                return customerType;
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return null;
    }
}
