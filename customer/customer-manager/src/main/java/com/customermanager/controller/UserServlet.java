package com.customermanager.controller;

import com.customermanager.model.ERole;
import com.customermanager.model.User;
import com.customermanager.service.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/userServlet")

public class UserServlet extends HttpServlet {
    private IUser iUser;

    @Override
    public void init(ServletConfig config) throws ServletException {
        iUser = new IUserMySqlIplm();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createUser":
                showCreateUser(request, response);
                break;
            case "editUser":
                showEditUser(request, response);
                break;
            case "deleteUser":
                showDeleteUser(request, response);
                break;
            default:
                showUser(request, response);
        }
    }

    private void showDeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idUser = Long.parseLong(request.getParameter("id"));
        User user = iUser.findById(idUser);
        request.setAttribute("user", user);
        ERole roles[] = ERole.values();
        request.setAttribute("roles", roles);
        request.getRequestDispatcher("user/deleteUser.jsp").forward(request, response);
    }

    private void showEditUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idUser = Long.parseLong(request.getParameter("id"));
        User user = iUser.findById(idUser);
        request.setAttribute("user", user);
        ERole roles[] = ERole.values();
        request.setAttribute("roles", roles);
        request.getRequestDispatcher("user/editUser.jsp").forward(request, response);
    }

    private void showCreateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ERole[] roles = ERole.values();
        request.setAttribute("roles", roles);
        request.getRequestDispatcher("user/createUser.jsp").forward(request, response);
    }

    private void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = iUser.findAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("user/listUser.jsp").forward(request, response);
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
            case "createUser":
                try {
                    createUser(request, response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "editUser":
                try {
                    editUser(request, response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deleteUser":
                deleteUser(request, response);
                break;
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long idUser = Long.parseLong(request.getParameter("id"));
        iUser.remove(idUser);
        response.sendRedirect("/userServlet");
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
        long idUser = Long.parseLong(request.getParameter("id"));
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(request.getParameter("dob"));
        LocalDate dob = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        ERole role = ERole.getERoleUser(request.getParameter("role"));
        User user = iUser.findById(idUser);
        user.setFullName(fullName);
        user.setAddress(address);
        user.setDob(dob);
        user.setRole(role);
        request.setAttribute("user", user);
        iUser.update(user.getIdUser(), user);
        request.setAttribute("message", "Customer information was updated");
        ERole roles[] = ERole.values();
        request.setAttribute("roles", roles);
        request.getRequestDispatcher("user/editUser.jsp").forward(request, response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(request.getParameter("dob"));
        LocalDate dob = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        ERole role = ERole.getERoleUser(request.getParameter("role"));
        User user = new User(System.currentTimeMillis() / 1000, fullName, address, dob, role);
        iUser.save(user);
        request.setAttribute("user", user);
        request.setAttribute("message", "New customer was created");
        ERole roles[] = ERole.values();
        request.setAttribute("roles", roles);
        request.getRequestDispatcher("user/createUser.jsp").forward(request, response);
    }
}
