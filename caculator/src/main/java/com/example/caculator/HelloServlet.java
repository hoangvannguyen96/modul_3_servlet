package com.example.caculator;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/calculator")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    float num1 =Float.parseFloat(request.getParameter("num1"));
    float num2 =Float.parseFloat(request.getParameter("num2"));
    char operator =request.getParameter("operator").charAt(0);
    float result = Calculator.calculator(num1,num2,operator);
    PrintWriter writer = response.getWriter();
    writer.println("<html>");
    writer.println("Result: "+num1+" "+operator+" "+num2+" "+"= "+result);
    writer.println("</html>");
    }

    public void destroy() {
    }
}