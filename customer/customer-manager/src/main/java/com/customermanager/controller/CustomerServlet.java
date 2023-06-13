package com.customermanager.controller;

import Utils.ValiDateUtil;
import com.customermanager.model.Customer;
import com.customermanager.model.CustomerType;
import com.customermanager.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")

public class CustomerServlet extends HttpServlet {
    private ICustomerService ICustomerService;
    private ICustomerType IcustomerType;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ICustomerService = new ICustomerMySqlIplm();
        IcustomerType = new CustomerTypeMySqlIplm();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreatForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            default:
                showCustomer(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }
    }
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCustomer = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.ICustomerService.findById(idCustomer);
        request.setAttribute("customer", customer);
        List<CustomerType> customerTypes = IcustomerType.findAll();
        request.setAttribute("customerTypes", customerTypes);
        request.getRequestDispatcher("customer/delete.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCustomer = Integer.parseInt(request.getParameter("id"));
        Customer customer = ICustomerService.findById(idCustomer);
        request.setAttribute("customer", customer);
        List<CustomerType> customerTypes = IcustomerType.findAll();
        request.setAttribute("customerTypes", customerTypes);
        request.getRequestDispatcher("customer/edit.jsp").forward(request, response);
    }

     private void showCreatForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypes = IcustomerType.findAll();
        request.setAttribute("customerTypes", customerTypes);
        request.getRequestDispatcher("customer/create.jsp").forward(request, response);
    }

    private void showCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Customer> customers = this.ICustomerService.findAll();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("customer/list.jsp").forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idCustomer = Integer.parseInt(request.getParameter("id"));
        ICustomerService.remove(idCustomer);
        response.sendRedirect(request.getContextPath() + "/customers");
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        int idCustomer = Integer.parseInt(request.getParameter("id"));
        Customer customer = ICustomerService.findById(idCustomer);
        validateInputName(request, errors, customer);
        validateInputEmail(request, errors, customer);
        validateInputAddress(request, errors, customer);
        validateInputCustomerType(request, errors, customer);
        if (errors.isEmpty()) {
            ICustomerService.update(customer.getIdCustomer(), customer);
            request.setAttribute("message", "Customer information was updated");
        } else {
            request.setAttribute("customer", customer);
            request.setAttribute("errors", errors);
            List<CustomerType> customerTypes = IcustomerType.findAll();
            request.setAttribute("customerTypes", customerTypes);
        }
        request.getRequestDispatcher("customer/edit.jsp").forward(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        Customer customer = new Customer();
        validateInputName(request, errors, customer);
        validateInputEmail(request, errors, customer);
        validateInputAddress(request, errors, customer);
        validateInputCustomerType(request, errors, customer);
        customer.setIdCustomer((int) (System.currentTimeMillis() / 1000000000));
        customer.setCreateAt(new Date());
        if (errors.isEmpty()) {
            ICustomerService.save(customer);
            request.setAttribute("message", "New customer was created");
            request.getRequestDispatcher("customer/create.jsp").forward(request, response);
        } else {
            request.setAttribute("customer", customer);
            request.setAttribute("errors", errors);
        }
        List<CustomerType> customerTypes = IcustomerType.findAll();
        request.setAttribute("customerTypes", customerTypes);
        request.getRequestDispatcher("customer/create.jsp").forward(request, response);
    }

    private void validateInputEmail(HttpServletRequest request, List<String> errors, Customer customer) {
        String email = request.getParameter("email");
        if (!ValiDateUtil.isEmailValid(email)) {
            errors.add("Email không hợp lệ");
        }
        customer.setEmail(email);
    }

    private void validateInputName(HttpServletRequest request, List<String> errors, Customer customer) {
        String name = request.getParameter("name");
        if (!ValiDateUtil.isNameValid(name)) {
            errors.add("Tên không hợp lệ. Tên phải từ 8-20 kí tự và bắt đầu là chữ cái");
        }
        customer.setName(name);
    }

    private void validateInputAddress(HttpServletRequest request, List<String> errors, Customer customer) {
        String address = request.getParameter("address");
        if (!ValiDateUtil.isAddressValid(address)) {
            errors.add("Địa chỉ không hợp lệ. Địa chỉ phải từ 8-20 kí tự và bắt đầu là chữ cái!");
        }
        customer.setAddress(address);
    }

    private void validateInputCustomerType(HttpServletRequest request, List<String> errors, Customer customer) {
        try {
            int idType = Integer.parseInt(request.getParameter("customerTypes"));
            CustomerType customerType = IcustomerType.findById(idType);
            if (customerType == null) {
                errors.add("Không tìm thấy loại khách hàng");
                customer.setIdType(1);
            } else {
                customer.setIdType(idType);
            }
        } catch (NumberFormatException numberFormatException) {
            errors.add("Loại khách hàng không hợp lệ");
        }
    }
}
