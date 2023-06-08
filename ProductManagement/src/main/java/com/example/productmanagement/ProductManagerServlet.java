package com.example.productmanagement;

import com.example.productmanagement.product.Product;
import com.example.productmanagement.product.ProductService;
import com.example.productmanagement.product.ProductServiceIplm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductManagerServlet", value = "/productManagerServlet")
public class ProductManagerServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productService = new ProductServiceIplm();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "search":
                break;
            case "delete":
                showProduct(request, response);
                break;
            default:
                showProduct(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:

        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String search = request.getParameter("search");
        List<Product> products = productService.findAll();
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            if (search.equalsIgnoreCase(product.getNameProduct())){
                productList.add(product);
            }
        }
        request.setAttribute("products", productList);
        request.getRequestDispatcher("/listsearch.jsp").forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        productService.remove(id);
        response.sendRedirect("/productManagerServlet");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Product product = productService.findById(id);
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        product.setNameProduct(name);
        product.setPriceProduct(price);
        product.setDescription(description);
        product.setProducer(producer);
        request.setAttribute("product", product);
        request.setAttribute("message", "Customer information was updated");
        productService.update(product.getId(), product);
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        Product product = new Product(System.currentTimeMillis() / 1000, name, price, description, producer);
        productService.save(product);
        request.setAttribute("message", "New customer was created");
        request.getRequestDispatcher("/create.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/create.jsp").forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/delete.jsp").forward(request, response);
    }

}