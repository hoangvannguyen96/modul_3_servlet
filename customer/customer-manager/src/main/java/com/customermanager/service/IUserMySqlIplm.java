package com.customermanager.service;

import com.customermanager.model.ERole;
import com.customermanager.model.Product;
import com.customermanager.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class IUserMySqlIplm extends DBContext implements IUser {
    public static final String FINDALL_CUSTOMER = "SELECT * FROM salesproject.user;";
    public static final String SAVE_CUSTOMER = "INSERT INTO `salesproject`.`user` (`fullName`, `address`, `dob`, `role`) VALUES (?, ?, ?, ?);";
    public static final String FINDBYID_CUSTOMER = "SELECT * FROM salesproject.user where (`idUser`=?)";
    public static final String UPDATE_CUSTOMER = "UPDATE `salesproject`.`user` SET `fullName` = ?, `address` = ?, `dob` = ?, `role` = ? WHERE (`idUser` = ?);";
    public static final String DELETE_CUSTOMER = "DELETE FROM `salesproject`.`user` WHERE (`idUser` = ?);";

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FINDALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idUser = resultSet.getLong("idUser");
                String fullName = resultSet.getString("fullName");
                String address = resultSet.getString("address");
                LocalDate dob = resultSet.getDate("dob").toLocalDate();
                Date sqldeleteAt = resultSet.getDate("deleteAt");
                LocalDate deleteAt = null;
                if (sqldeleteAt != null) {
                    deleteAt = sqldeleteAt.toLocalDate();
                }
                String sqlrole = resultSet.getString("role");
                ERole role = ERole.getERoleUser(sqlrole);
                User user = new User(idUser, fullName, address, dob, deleteAt, role);
                users.add(user);
            }
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return users;
    }

    @Override
    public void save(User user) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CUSTOMER);
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getAddress());
            preparedStatement.setDate(3, Date.valueOf(user.getDob()));
            preparedStatement.setString(4, user.getRole().name());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }

    @Override
    public User findById(long idUser) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FINDBYID_CUSTOMER);
            preparedStatement.setLong(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idUser1 = resultSet.getLong("idUser");
                String fullName = resultSet.getString("fullName");
                String address = resultSet.getString("address");
                LocalDate dob = resultSet.getDate("dob").toLocalDate();
                Date sqldeleteAt = resultSet.getDate("deleteAt");
                LocalDate deleteAt = null;
                if (sqldeleteAt != null) {
                    deleteAt = sqldeleteAt.toLocalDate();
                }
                String sqlrole = resultSet.getString("role");
                ERole role = ERole.getERoleUser(sqlrole);
                User user = new User(idUser1, fullName, address, dob, deleteAt, role);
                return user;
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return null;
    }

    @Override
    public void update(long idUser, User user) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getAddress());
            preparedStatement.setDate(3, Date.valueOf(user.getDob()));
            preparedStatement.setString(4, user.getRole().name());
            preparedStatement.setLong(5, idUser);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }

    }

    @Override
    public void remove(long idUser) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setLong(1, idUser);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }
}
