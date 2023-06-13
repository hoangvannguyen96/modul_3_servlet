package com.customermanager.controller;

import com.customermanager.model.Category;
import com.customermanager.model.Customer;
import com.customermanager.model.CustomerType;
import com.customermanager.model.Product;
import com.customermanager.service.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/productServlet")

public class ProductServlet extends HttpServlet {
    private IProductService iProductService;
    private ICategory iCategory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        iProductService = new IProductMySqlIplm();
        iCategory = new ICategoryMySqlIplm();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createProduct":
                showCreateProduct(request, response);
                break;
            case "editProduct":
                showEditProduct(request,response);
                break;
            case "deleteProduct":
                showDeleteProduct(request,response);
                break;
            default:
                showProduct(request, response);
        }
    }

    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idProduct = Long.parseLong(request.getParameter("id"));
        Product product = iProductService.findById(idProduct);
        request.setAttribute("product", product);
        List<Category> categories = iCategory.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("product/deleteProduct.jsp").forward(request, response);
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idProduct = Long.parseLong(request.getParameter("id"));
        Product product = iProductService.findById(idProduct);
        request.setAttribute("product", product);
        List<Category> categories=iCategory.findAll();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("product/editProduct.jsp").forward(request, response);
    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = iCategory.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("product/createProduct.jsp").forward(request, response);
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = iProductService.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("product/listProduct.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createProduct":
                createProduct(request, response);
                break;
            case "editProduct":
                editProduct(request,response);
                break;
            case "deleteProduct":
                deleteProduct(request,response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long idProduct = Long.parseLong(request.getParameter("id"));
        iProductService.remove(idProduct);
        response.sendRedirect("/productServlet");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idProduct = Long.parseLong(request.getParameter("id"));
        String nameProduct = request.getParameter("nameProduct");
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        long idCategory = Long.parseLong(request.getParameter("categories"));
        Product product = iProductService.findById(idProduct);
        product.setNameProduct(nameProduct);
        product.setPrice(price);
        product.setDescription(description);
        java.util.Date createAtUtil = new java.util.Date();
        LocalDate createAt = createAtUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        product.setCreateAt(createAt);
        product.setIdCategory(idCategory);
        request.setAttribute("product", product);
        iProductService.update(product.getIdProduct(), product);
        request.setAttribute("message", "Customer information was updated");
        List<Category> categories=iCategory.findAll();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("product/editProduct.jsp").forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameProduct = request.getParameter("nameProduct");
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        long idCategory = Long.parseLong(request.getParameter("categories"));
        java.util.Date createAtUtil = new java.util.Date();
        LocalDate createAt = createAtUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Product product = new Product(System.currentTimeMillis() / 1000, nameProduct, description, createAt, price, idCategory);
        iProductService.save(product);
        request.setAttribute("product", product);
        request.setAttribute("message", "New customer was created");
        List<Category> categories = iCategory.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("product/createProduct.jsp").forward(request, response);
    }
}
