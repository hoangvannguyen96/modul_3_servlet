package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceMySql implements IProductService {
    private String jdbcURL = "jdbc:mysql://127.0.0.1:3306/products?&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "nguyen392483";

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products.product;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                String description = resultSet.getString("description");
                String producer = resultSet.getString("producer");
                Product product = new Product(id, name, price, description, producer);
                products.add(product);
            }
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return products;
    }

    @Override
    public void add(Product product) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `products`.`product` (`name`, `price`, `description`, `producer`) VALUES (?, ?, ?, ?);");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getProducer());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }

    @Override
    public void update(long id, Product product) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `products`.`product` SET `name` = ?, `price` = ?, `description` = ?, `producer` = ? WHERE (`id` = ?);");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getProducer());
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }

    @Override
    public void delete(long id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `products`.`product` WHERE (`id` = ?);");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }

    }

    @Override
    public Product findById(long id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products.product where (`id` =?);");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idProduct = resultSet.getLong("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                String description = resultSet.getString("description");
                String producer = resultSet.getString("producer");
                Product product = new Product(idProduct, name, price, description, producer);
                return product;
            }
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return null;
    }
}
